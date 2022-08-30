package com.myfitness.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.myfitness.domain.Member;

public interface MemberService {

//	List<Member> getMemberList();
	
	Page<Member> getMemberList(Pageable pageable);
	
	Page<Member> getSearchNameMemberList(String searchKeyword, Pageable pageable);
	
	Page<Member> getSearchPhoneMemberList(String searchKeyword, Pageable pageable);
	
	void create(Member member);
	
	Member getMember(String mid);

}