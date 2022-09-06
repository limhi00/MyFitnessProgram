package com.myfitness.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myfitness.domain.Member;
import com.myfitness.domain.Role;
import com.myfitness.persistence.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberDetailsServiceImpl implements UserDetailsService {

	private final MemberRepository memberRepo; 	
	
	@Override
	public UserDetails loadUserByUsername(String username) 
									throws UsernameNotFoundException {
		Optional<Member> optional = memberRepo.findById(username);

		if(!optional.isPresent()) {
			throw new UsernameNotFoundException("존재하지 않는" + username + "입니다.");
		} else {
			Member member = optional.get();
			return new MemberDetail(member);
		}
	}
}
