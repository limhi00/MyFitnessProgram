package com.myfitness.config;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//public class SecurityConfig {
//	
//	@Autowired
//	private DataSource dataSource;
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
//		security.authorizeRequests().antMatchers("/").permitAll(); // 모든 사용자 접근 가능
//		security.authorizeRequests().antMatchers("/login/**").permitAll(); // 모든 사용자 접근 가능
//		security.authorizeRequests().antMatchers("/board/**").authenticated(); // 로그인 성공한 인증 사용자만 접근 가능
//		security.authorizeRequests().antMatchers("/diet/**").authenticated(); // 로그인 성공한 인증 사용자만 접근 가능
//		security.authorizeRequests().antMatchers("/class/**").hasRole("PTMEMBER"); // 'PTMEMBER'권한을 가진 사용자만 접근 가능
//		security.authorizeRequests().antMatchers("/trainer/**").hasRole("TRAINER"); // 'TRAINER'권한을 가진 사용자만 접근 가능
//		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN"); // 'ADMIN'권한을 가진 사용자만 접근 가능
//		
//		security.csrf().disable();
//		security.formLogin().loginPage("/login").defaultSuccessUrl("/", true);
//		security.exceptionHandling().accessDeniedPage("/login");
//		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
//		
//		security.userDetailsService(userDetailsService); 
//		
//		return security.build();
//	}
//	
//	
//	@Bean 
//	public PasswordEncoder passwordEncoder() {
//	  
//	  return PasswordEncoderFactories.createDelegatingPasswordEncoder(); 
//	}
//	 
//}