package com.myfitness.service;

import java.util.List;
import com.myfitness.domain.Member;

public interface MemberService {
	
	Member createForm(String name, String username, String email, String password, String phone);
	Member getMember(String username); // 아이디를 조건으로 회원 검색
	void modifyMemberInfo(Member member); // 회원 수정
	void deleteMember(String username); // 회원 탈퇴	
	List<Member> getMemberList(); // 회원 목록

}