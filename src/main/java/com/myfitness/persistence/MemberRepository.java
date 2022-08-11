package com.myfitness.persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.myfitness.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
