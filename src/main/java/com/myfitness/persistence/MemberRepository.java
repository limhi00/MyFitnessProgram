package com.myfitness.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import com.myfitness.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
