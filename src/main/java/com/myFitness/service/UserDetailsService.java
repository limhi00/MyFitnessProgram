package com.myFitness.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myFitness.domain.Member;
import com.myFitness.persistence.MemberRepository;

//@Service
//public class UserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private MemberRepository memRepo;
//
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		Optional<Member> optionalUser = memRepo.findById(username);
//
//		if (optionalUser.isPresent()) {
//			Member member = optionalUser.get();
//
//			return new SecurityUser(member);
//		} else {
//			throw new UsernameNotFoundException(username + " 사용자 없음");
//		}
//	}
//}
