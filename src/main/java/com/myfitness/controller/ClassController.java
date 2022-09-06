package com.myfitness.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myfitness.config.SecurityConfig;
import com.myfitness.domain.ClassDiary;
import com.myfitness.domain.Member;
import com.myfitness.domain.Reservation;
import com.myfitness.domain.ReservationListDto;
import com.myfitness.service.MemberService;
import com.myfitness.service.ReservationService;

@Controller
public class ClassController {
	
	@Autowired
	private ReservationService resService;
	
	@Autowired
	private MemberService memService;
	
	//@Autowired
	//private classdia
	
	@GetMapping("/classCalendarView")
	public String classCalendarView() {
		
		return "class/classCalendar";
	}
	
	@GetMapping("/classCalendarList")
	@ResponseBody
	public Map<String, ReservationListDto> classCalendarList(Principal principal) {
		
		Map<String, ReservationListDto> eventMap = new HashMap<>();
		List<Reservation> resList = resService.getReservationList(principal.getName());
		
		int count = 0;
		for (Reservation re : resList) {
			System.out.println("resList" + re);
			ReservationListDto vo = new ReservationListDto();
			vo.setTitle("수업 확인");
			vo.setStart(re.getClassDate()+"T"+re.getClassTime()+":00:00");
			vo.setEnd(re.getClassDate()+"T"+re.getClassTime()+":50:00");
			vo.setUrl("/classChecking?rseq="+re.getRseq());
			vo.setColor("#2C3E50");
			vo.setTextColor("#000");
			
			eventMap.put("event"+count, vo);
			++count;
		}
		
		return eventMap;
	}
	
	@GetMapping("/classChecking")
	public String classChecking(@RequestParam("rseq") Long rseq, Model model, Reservation res,RedirectAttributes rattr) {
		
		System.out.println("rseq="+rseq);
		res = resService.getReservation(rseq);
		System.out.println("reservation="+res);
		model.addAttribute("reservation", res);
		rattr.addAttribute("rseq", rseq);
		
		return "class/classChecking";
	}
	
	@GetMapping("/classReservation")
	public String classReservationView(Principal principal, Model model, @RequestParam String classDate) {
		
		model.addAttribute("name", principal.getName());
		model.addAttribute("classDate", classDate);
		
		return "class/classReservation";
	}
	
	@PostMapping("/classReservation")
	public String classReservation(RedirectAttributes rattr, Reservation res  ) {
		
		Long rseq = resService.insertReservation(res);
		rattr.addAttribute("rseq", rseq);
		
		return "redirect:/classChecking";
	}
	
	
	@GetMapping("/classCancel")
	public String classCancleView(Model model, Reservation res,  @RequestParam("rseq") Long rseq,RedirectAttributes rattr, Member mem) {
		
		//mem = memService.getMember(password);
		res = resService.getReservation(rseq);
		model.addAttribute("reservation", res);
		rattr.addAttribute("rseq", rseq);
		//rattr.addAttribute("password", password);
		
		return "class/classCancel";
	}
	
	@PostMapping("/classCancel")
	public String classCancle(Reservation res, @RequestParam("password") String password, Principal principal, Model model) {
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		//String encodedPwd = pwdEncoder.encode(password); // 화면에서 입력된 비밀번호를 암호화
		
		Member member = memService.getMember(principal.getName());
		
		if(member != null && pwdEncoder.matches(password, member.getPassword())) {
			resService.deleteReservation(res);
			return "redirect:/classCalendarView";
		} else {
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "class/classCancel";
		}	
	}
	
}
