package com.myFitness.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
	
	@GetMapping("/_layout")
	public String layout() {
		// 레이아웃 테스트용 메서드. 
		// 내용 부분에 소스 붙여넣고 사이드 바, 내용 출력, 푸터 위치 확인 
		return "layout/_layout";
	}
	
	@GetMapping("/_layout2")
	public String layout2() {
		// 레이아웃 테스트용 메서드. 
		// 내용 부분에 소스 붙여넣고 사이드 바, 내용 출력, 푸터 위치 확인 
		return "layout/_layout2";
	}
	
	@GetMapping("/sample")
	public String sample() {
		// 레이아웃 테스트용 메서드. 
		// 내용 부분에 소스 붙여넣고 사이드 바, 내용 출력, 푸터 위치 확인 
		return "sample";
	}

	@GetMapping("/sample2")
	public String sample2() {
		// 레이아웃 테스트용 메서드. 
		// 내용 부분에 소스 붙여넣고 사이드 바, 내용 출력, 푸터 위치 확인 
		return "sample2";
	}
	
	@GetMapping("/joinTest")
	public String joinTest() {
		// 레이아웃 테스트용 메서드. 
		// 내용 부분에 소스 붙여넣고 사이드 바, 내용 출력, 푸터 위치 확인 
		return "login/joinTest";
	}
	@GetMapping("/index2")
	public String sdaasd() {
		// 레이아웃 테스트용 메서드. 
		// 내용 부분에 소스 붙여넣고 사이드 바, 내용 출력, 푸터 위치 확인 
		return "index2";
	}

}
