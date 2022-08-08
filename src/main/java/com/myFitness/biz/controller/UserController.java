package com.myFitness.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/login")
	public String loginView() {
		
		return "login/login";
	}

	@GetMapping("/join")
	public String joinView() {

		return "login/join";
	}
	
	@GetMapping("/mypage")
	public String mypageView() {

		return "login/mypage";
	}
	
	@GetMapping("/findId")
	public String findIdView() {
		
		return "login/findId";
	}
	
	@GetMapping("/findId_get")
	public String findId_getView() {
		
		return "login/findId_get";
	}
	
	@GetMapping("/findId_notFound")
	public String findId_notFoundView() {
		
		return "login/findId_notFound";
	}
	
	@GetMapping("/findPwd")
	public String findPwdView() {
		
		return "login/findPwd";
	}
	
	@GetMapping("/findPwd_get")
	public String findPwd_getView() {
		
		return "login/findPwd_get";
	}

	
}
