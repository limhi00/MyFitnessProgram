package com.myfitness.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.myfitness.domain.Member;
import com.myfitness.domain.Role;

public class MemberDetail implements UserDetails {
	
	private Member member;
	
	public MemberDetail(Member member) {
		this.member = member;
	}
	
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return ""+member.getRole();
            }
        });
        return collection;
    }
	
	@Override
	public String getUsername() {
		return member.getUsername();
	}
	
	public String getName() {
		return member.getName();
	}

	@Override
	public String getPassword() {
		return member.getPassword();
	}

	public String getPhone() {
		return member.getPhone();
	}
	
	public Role getRole() {
		return member.getRole();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}