package com.myfitness.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {
	
	private final MemberDetailsServiceImpl memberDetailsServiceImpl;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		//http.exceptionHandling().accessDeniedPage("/access-denied"); 권한이 없는데 접근했을 시 보여줄 html
		
		http.authorizeRequests()
			.antMatchers("/**").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")	// URL에 따른 권한만 허용
			.antMatchers("/trainer/**").access("hasRole('ROLE_TRAINER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/mypage/**").access("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')");
		
        http.formLogin()
	    	.loginPage("/login")
	    	.loginProcessingUrl("/login")
	    	.defaultSuccessUrl("/");
        	
        http.logout()
	    	.logoutUrl("/logout")
	    	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	    	.invalidateHttpSession(true)
	    	.logoutSuccessUrl("/login?logout").permitAll();
        
//	    http.sessionManagement()
//			.maximumSessions(-1);
     
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(memberDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }
}
