package com.myfitness.service;

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

	private final MemberRepository memberRepo;
	private final PasswordEncoder passwordEncoder;
	
	public Page<Member> getMemberList(Pageable pageable) {
		
		return memberRepo.findAll(pageable);
	}
	
	public Page<Member> getSearchNameMemberList(String searchKeyword, Pageable pageable) {
		
		return memberRepo.findByNameContaining(searchKeyword, pageable);
	}
	
	public Page<Member> getSearchPhoneMemberList(String searchKeyword, Pageable pageable) {
		
		return memberRepo.findByPhoneContaining(searchKeyword, pageable);
	}
	
	@Override // 회원가입
	public Member createForm(String username, String name, String email, String password, String phone) {
		if(memberRepo.findById(username).isPresent()) {
			return null; //
		} else {
			Member member = new Member();
			member.setUsername(username);
			member.setEmail(email);
			member.setName(name);
			member.setPassword(passwordEncoder.encode(password));
			member.setPhone(phone);
			member.setRole(Role.ROLE_MEMBER);
			memberRepo.save(member);
		}
		return null;
	}
	
	@Override // 아이디를 조건으로 회원 검색
	public Member getMember(String username) {
		Optional<Member> findMember = memberRepo.findById(username);
		if (findMember.isPresent()) {
			return findMember.get();
		} else {
			return null;
		}
	}
	
	@Override // 마이페이지 회원정보 수정
	public void modifyMemberInfo(Member member) {
		String encodePassword = passwordEncoder.encode(member.getPassword());
		member.setPassword(encodePassword);
		member.setRole(Role.ROLE_MEMBER);
		memberRepo.save(member);
	}
	
	@Override // 마이페이지 회원탈퇴
	public void deleteMember(String username) {
		memberRepo.deleteById(username);
	}
	
}