package com.myfitness.controller;

import java.util.LinkedHashMap;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.myfitness.domain.Member;
import com.myfitness.domain.Role;
import com.myfitness.dto.MemberJoinDTO;
import com.myfitness.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SessionAttributes("member")
@Controller
public class MemberController {
	private final MemberService memberService;

    @GetMapping("/join")
    public String signup(MemberJoinDTO memberJoinDTO) {
        return "members/join";
    }

    @PostMapping("/join") 
    public String signup(@Valid MemberJoinDTO memberJoinDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/join";
        }
        if (!memberJoinDTO.getPassword1().equals(memberJoinDTO.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordNotMatch", 
                    "비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
            return "members/join";
        }
        memberService.joinMember(memberJoinDTO.getUsername(),
				        		memberJoinDTO.getName(),
				        		memberJoinDTO.getEmail(),
				        		memberJoinDTO.getPassword1(),
				        		memberJoinDTO.getPhone(),
				        		memberJoinDTO.getRole());
        
	        return "redirect:/login"; 
	    }
    
	@GetMapping("/login")
	public String loginForm() {	return "members/login"; }
    
	@GetMapping("/findId") // 아이디찾기
	public String findId(Model model) {
		
		return "members/findId";
	}
	
	@GetMapping("/findPwd") // 비밀번호 찾기
	public String findPwd(Model model) {
		
		return "members/findPwd";
	}
    
	// 마이페이지 폼
	@PreAuthorize("isAuthenticated() and (( #username == principal.username ) or hasRole('ROLE_ADMIN'))")
	@GetMapping("/mypage/{username}")
	public String myPage(Model model, @PathVariable("username") String username) {
		model.addAttribute("member", memberService.getMember(username));
		
		return "members/mypage";
	}
    
	// 마이페이지 리다이렉트
	@PostMapping("/mypage/{username}") 
	public String myPageModify(@PathVariable("username") String username, Member member) {
		memberService.modifyMemberInfo(member);

		return "redirect:/mypage/{username}";
	}
	
    @GetMapping("/mypage/delete")
    public String memberDelete(String username) {
        memberService.deleteMember(username);

        return "redirect:/logout";
    }
	
    @ModelAttribute("roles") // 
    public Map<String, Role> roles() {
    	Map<String, Role> map = new LinkedHashMap<>();
    	map.put("회원", Role.ROLE_MEMBER);
    	map.put("트레이너", Role.ROLE_TRAINER);
    	map.put("관리자", Role.ROLE_ADMIN);
    	return map; 
    }
}