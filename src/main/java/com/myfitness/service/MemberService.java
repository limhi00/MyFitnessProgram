package com.myfitness.service;

import java.util.List;
import com.myfitness.domain.Member;

public interface MemberService {

	List<Member> getMemberList();
	
	void create(Member member);
	
	Member getMember(String mid);

}