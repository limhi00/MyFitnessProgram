package com.myfitness.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myfitness.domain.Member;
import com.myfitness.domain.Role;
import com.myfitness.persistence.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	// 생성자 주입
	private final MemberRepository memberRepo;
	// @Bean으로 등록한 PasswordEncoder를 사용한다.
	private final PasswordEncoder passwordEncoder;
	
	public void create(Member member) {
		member.setMid(member.getMid());
		member.setName(member.getName());
		member.setEmail(member.getEmail());
        member.setPassword(passwordEncoder.encode(member.getPassword()));
		// 시큐리티 PasswordEncoder로 대체 member.setPassword(member.getPassword());
		member.setCreateDate(LocalDateTime.now());
		member.setRole(Role.ROLE_MEMBER);
		//this.memberRepo.save(member);
		memberRepo.save(member);
	}
	
//	public Member getMember(Member member) {
//		
//		return memberRepo.findByMid(member.getMid()).getMid();
//	}
	
	
//	@Override
//	public List<Member> getMemberList() {
//		// 1. findAll 메서드 호출 Entity타입의 List에 호출 결과를 저장한다.
//		List<Member> memberList = memberRepo.findAll();
//		// 필요한 DTO의 정보가 동일하기 때문에 따로 사용하지 않고 객체를 바로 사용
//		return memberList;
//	}
	
	public Page<Member> getMemberList(Pageable pageable) {
		
		return memberRepo.findAll(pageable);
	}
	
	public Page<Member> getSearchNameMemberList(String searchKeyword, Pageable pageable) {
		
		return memberRepo.findByNameContaining(searchKeyword, pageable);
	}
	
	public Page<Member> getSearchPhoneMemberList(String searchKeyword, Pageable pageable) {
		
		return memberRepo.findByPhoneContaining(searchKeyword, pageable);
	}

	@Override
	public Member getMember(String mid) {
		// (1) MemberRepository에서 특정 회원의 id로 회원 검색하여 리턴한다.
		Optional<Member> findMember = memberRepo.findById(mid);
		//Optional<Member> findMember2 = memberS
		
		// (2) 회원이 존재하는지 확인
		// Optional의 isEmpty, isPresent()
		if (findMember.isPresent()) {
			return findMember.get();
		} else {
			return null; 
		}
	}
}
