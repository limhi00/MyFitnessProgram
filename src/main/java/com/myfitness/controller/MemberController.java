package com.myfitness.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.myfitness.domain.Member;
import com.myfitness.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@SessionAttributes("member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	// 회원가입
	@GetMapping("save")
	public String save() {
		return "member/save";
	}
	
	// 회원가입
	@PostMapping("save")
	public String save(Member member) {
		memberService.create(member);
		
		return "redirect:/"; 
	}
	
	// 전체 회원 목록
	@GetMapping("memberList")
	public String memberList(Model model) {
		List<Member> memberList = memberService.getMemberList();
		model.addAttribute("memberList", memberList);
		return "member/memberList";
	}
	
	// 로그인 페이지
	@GetMapping("login")
	public String loginForm() {
		return "member/login";
	}
	
	// 로그인
	@PostMapping("login")
	public String login(String mid, Model model, Member member) {
		
		// (1) 아이디가 설정된 Member 객체와 MemberService를 이용해 회원 정보 검색 
		//      DB에서 member를 조회해 loginMember에 넣고 유효성을 검사한다.
		Member loginMember = memberService.getMember(mid);

		//  (2) DB에서 ID를 조건으로 조회된 member가 있으며 비밀번호가 일치하면
		//      loginMember 변수는 Model을 통해 member 세션에 저장된다.
		if(loginMember != null && loginMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", loginMember);
			
			return "redirect:/";
		} else {
			return "redirect:/login";
		}
	}
	
	// 로그아웃
	@GetMapping("logout")
	public String logout(SessionStatus status) {
		status.setComplete(); // 세션 값 비우기.
		
		return "redirect:/";
	}
	
	// 마이페이지 폼
	@GetMapping("/member/mypage/{mid}")
	public String myPage(Model model, @PathVariable("mid") String mid) {
		Member member = memberService.getMember(mid);
		model.addAttribute("member", member);
		return "member/mypage";
	}
	
}
