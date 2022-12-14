package com.myfitness.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myfitness.domain.ClassDiary;
import com.myfitness.domain.FullCalendarDto;
import com.myfitness.domain.Member;
import com.myfitness.domain.Reservation;
import com.myfitness.service.MemberService;
import com.myfitness.service.ReservationService;

@Controller
public class ClassController {
	
	@Autowired
	private ReservationService resService;
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/classCalendar")
	public String classCalendar() {
		
		return "class/classCalendar";
	}
	@GetMapping("/classCalendarView")
	public String classCalendarView() {
		
		return "redirect:/classCalendar";
	}
	
	@GetMapping("/classCalendarList")
	@ResponseBody
	public Map<String, FullCalendarDto> classCalendarList(Principal principal) {
		
		Map<String, FullCalendarDto> eventMap = new HashMap<>();
		List<Reservation> resList = resService.getReservationList(principal.getName());
		
		int count = 0;
		for (Reservation re : resList) {
			FullCalendarDto vo = new FullCalendarDto();
			vo.setTitle("수업 확인");
			vo.setStart(re.getClassDate()+"T"+re.getClassTime()+":00:00");
			vo.setEnd(re.getClassDate()+"T"+re.getClassTime()+":50:00");
			vo.setUrl("/classChecking?rseq="+re.getRseq());
			vo.setColor("#ff4800");
			vo.setTextColor("#fff");
			
			eventMap.put("event"+count, vo);
			++count;
		}
		
		return eventMap;
	}
	
	@GetMapping("/classChecking")
	public String classChecking(@RequestParam("rseq") Long rseq, Model model, Reservation res) {
		
//		System.out.println("rseq="+rseq);
//		System.out.println("reservation="+res);
		res = resService.getReservation(rseq);
		String cTrainerName = resService.getCTrainerName(res.getCTrainer());
		String username = resService.getCTrainerName(res.getMember().getUsername());
		model.addAttribute("reservation", res);
		model.addAttribute("cTrainer", cTrainerName);
		model.addAttribute("username", username);
		
		return "class/classChecking";
	}
	
	@GetMapping("/classReservation")
	public String classReservationView(Principal principal, Model model, @RequestParam String classDate, String role) {
		
		model.addAttribute("cTrainerList", resService.getCTrainerList(role));
		model.addAttribute("name", principal.getName());
		model.addAttribute("classDate", classDate);
		
		return "class/classReservation";
	}
	
	@PostMapping("/classReservation")
	public String classReservation(RedirectAttributes rattr, Reservation res) {
		
		Long rseq = resService.insertReservation(res);
		
		rattr.addAttribute("rseq", rseq);
		
		return "redirect:/classChecking";
	}
	
	@GetMapping("/classCancelView")
	public String classCancleView(@RequestParam("rseq") Long rseq, Model model, Reservation res) {
		
		res = resService.getReservation(rseq);
		model.addAttribute("reservation", res);
		
		return "class/classCancel";
	}
	
	@RequestMapping("/classCancel")
	public String classCancle(Reservation res, @RequestParam("password") String password, Principal principal, Model model) {
		
		Long cdseq = resService.getClassDiary(res.getRseq()).getCdseq();
		
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		Member member = memberService.getMember(principal.getName());
		
		if (member != null && pwdEncoder.matches(password, member.getPassword())) {
			resService.deleteClassDiary(cdseq);
			System.out.println("deleteClassDiary seccess!!");
			return "/class/classCancelResult";
		} else {
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "class/classCancel";
		}
	}
	
	@GetMapping("/getClassDiary")
	public String getClassDiary(Long rseq, ClassDiary cDiary, Model model) {
		
		cDiary = resService.getClassDiary(rseq);
//		System.out.println("get rseq="+rseq);
//		System.out.println("get cDiary="+cDiary);
		cDiary.setReservation(resService.getReservation(rseq));
		model.addAttribute("cDiary", cDiary);
		
		return "class/getClassDiary";
	}
	
	@RequestMapping("/insertClassDiaryView")
	public String insertClassDiaryView(Long rseq, ClassDiary cDiary, Model model) {
		
		cDiary = resService.getClassDiary(rseq);
		System.out.println("rseq="+rseq);
		System.out.println("insertView cDiary="+cDiary);
		model.addAttribute("cDiary", cDiary);
		
		return "class/insertClassDiary";
	}
	
	@PostMapping("/insertClassDiary")
	public String insertClassDiary(Long rseq, ClassDiary cDiary, RedirectAttributes rattr) {
		
//		System.out.println("insertCDiary rseq="+rseq);
		ClassDiary cd = resService.findClassDiary(resService.getReservation(rseq));
		cd.setContent(cDiary.getContent());
//		System.out.println("insert cDiary="+cDiary);
		resService.insertClassDiary(cDiary);
		rattr.addAttribute("rseq", rseq);
		
		return "redirect:/getClassDiary";
	}
	
	@GetMapping("/classScheduleView")
	public String classScheduleView() {
		
		return "trainer/classSchedule";
	}
	
	@GetMapping("/classScheduleList")
	@ResponseBody
	public Map<String, FullCalendarDto> classScheduleList(Principal principal) {
		
		Map<String, FullCalendarDto> eventMap = new HashMap<>();
		List<Reservation> resList = resService.getTrainerReservationList(principal.getName());
		
		int count = 0;
		for (Reservation re : resList) {
			FullCalendarDto vo = new FullCalendarDto();
			vo.setTitle("수업 확인");
			vo.setStart(re.getClassDate()+"T"+re.getClassTime()+":00:00");
			vo.setEnd(re.getClassDate()+"T"+re.getClassTime()+":50:00");
			vo.setUrl("/classChecking?rseq="+re.getRseq());
			vo.setColor("#ff4800");
			vo.setTextColor("#fff");
			
			eventMap.put("event"+count, vo);
			++count;
		}
		
		return eventMap;
	}
}
