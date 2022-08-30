package com.myfitness.persistence;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myfitness.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	Page<Member> findByNameContaining(String SearchKeyword, Pageable pageable);
	
	Page<Member> findByPhoneContaining(String SearchKeyword, Pageable pageable);
}
