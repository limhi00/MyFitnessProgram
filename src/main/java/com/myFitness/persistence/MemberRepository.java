package com.myFitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myFitness.domain.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {

}
