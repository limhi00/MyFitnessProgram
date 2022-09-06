package com.myfitness.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.myfitness.domain.Board;
import com.myfitness.domain.Member;
import com.myfitness.domain.Role;
import com.myfitness.dto.MemberModifyDTO;

public interface MemberService {
	// 아이디를 조건으로 회원 검색
	Member getMember(String username);
	 
	// 회원 탈퇴	 
	void deleteMember(String username);
	
	// 회원가입
	Member joinMember(String username, String name, String email, String password, String phone, Role role);
	
	// 회원 수정
	void modifyMemberInfo(Member member);
	
	// 회원 아이디 조회
	Member getUsername(Member member, String username);
	
	/* 아이디, 비밀번호 찾기*/
	// 이름과 이메일을 조건으로 아이디 찾기.
	Member doFindId(String name, String email);
	// 아이디와 이메일을 조건으로 비밀번호 찾기.
	Member doFindPwd(String username, String email);

	Page<Member> getRoleList(String role, Pageable pageable);
	
	Page<Member> getSearchNameMemberList(String role, String searchKeyword, Pageable pageable);
	
	Page<Member> getSearchPhoneMemberList(String role, String searchKeyword, Pageable pageable);
}
