package com.myfitness.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myfitness.domain.Member;
import com.myfitness.persistence.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberDetailsServiceImpl implements UserDetailsService {

	private final MemberRepository memberRepo; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> findMember = memberRepo.findByUsername(username); // 실제 저장된 유저 정보 가져옴
		if (findMember.isPresent()) {
			return new MemberDetail(findMember.get());
		}
		throw new UsernameNotFoundException("존재하지 않는" + username + "입니다."); 
	}	
}