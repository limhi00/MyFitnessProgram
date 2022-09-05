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
	
	public Page<Member> getRoleList(String role, Pageable pageable) {
		
		return memberRepo.getRoleList(role, pageable);
	}
	
	public Page<Member> getSearchNameMemberList(String role, String searchKeyword, Pageable pageable) {
		
		return memberRepo.getByNameContaining(role, searchKeyword, pageable);
	}
	
	public Page<Member> getSearchPhoneMemberList(String role, String searchKeyword, Pageable pageable) {
		
		return memberRepo.getByPhoneContaining(role, searchKeyword, pageable);
	}
	
	@Override // 회원가입 (리턴타입이 Member? String)
	public String joinMember(String username, String name, String email,
							String password, String phone, Role role) {
		
		if(memberRepo.findByUsername(username).isPresent()) {
			throw new IllegalStateException("중복된 회원 ID가 존재합니다.");
		} else {
			Member member = new Member();
			member.setUsername(username);
			member.setEmail(email);
			member.setName(name);
			member.setPassword(passwordEncoder.encode(password));
			member.setPhone(phone);
			//member.setRole(Role.ROLE_MEMBER);
			member.setRole(role);
			memberRepo.save(member);
		}
		return null;
	}
	
	@Override // 아이디를 조건으로 회원 검색
	public Member getMember(String username) {
		Optional<Member> findMember = memberRepo.findByUsername(username);
		if (findMember.isPresent()) {
			return findMember.get();
		} else {
			return null;
		}
	}
	
	@Override // 마이페이지 회원정보 수정
	public void modifyMemberInfo(Member member) {
		member.getPassword();
		String encodePassword = passwordEncoder.encode(member.getPassword());
		member.setPassword(encodePassword);
		memberRepo.save(member);
		/*
		 * 비밀번호를 변경하지 않고 다른 정보만 수정하면 기존 비밀번호가 다시 암호화되어 다른 값이 되어버린다.
		 * 비밀번호 단독 수정이나 그 외 모든 수정은 비밀번호를 꼭 같이 수정해줘야 한다. 
		 */
	}
	
	@Override // 마이페이지 회원탈퇴
	public void deleteMember(String username) {
		memberRepo.deleteById(username);
	}
	
}