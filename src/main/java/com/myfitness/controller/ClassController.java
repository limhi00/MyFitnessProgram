package com.myfitness.controller;


import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myfitness.domain.ClassDiary;
import com.myfitness.domain.DietDiary;
import com.myfitness.domain.Reservation;
import com.myfitness.service.ClassDiaryService;
import com.myfitness.service.DietDiaryService;
import com.myfitness.service.MemberService;
import com.myfitness.service.ReservationService;


@Controller
public class ClassController {
	

	
	@Autowired(required=false)
	private DietDiaryService ddiaryservice;
	
	@Autowired
	private ReservationService reservice;
	
	@Autowired
	private ClassDiaryService cdiaryservice;
	

	@GetMapping("/afterClassList")
	public String afterClassListView() {
		
		return "class/afterClassList";
	}
	
	@GetMapping("/classCancel")
	public String classCancel(@RequestParam("rseq") long rseq, Reservation res, Model model ) {
		res.setRseq(rseq);
		model.addAttribute("Reservation", reservice.getRes(res));
		return "class/classCancel";
	}
	@RequestMapping("/deleteclassCancel")
	public String deleteclassCancel(Reservation res, Model model) {
		
		model.addAttribute("Reservation", reservice.getRes(res));
		
		return "class/classCancel";
	}
	
	@GetMapping("/classChecking")
	public String classCheckingView() {
		
		return "class/classChecking";
	}
	
	@GetMapping("/classDiary")
	public String classDiary(@RequestParam("cdseq") long cdseq, ClassDiary cdiary, Model model) {
		cdiary.setCdseq(cdseq);
		model.addAttribute("ClassDiary", cdiaryservice.getcdiary(cdiary));
		return "class/classDiary";
	}
	
	@GetMapping("/classReservation")
	public String classReservationView() {
		
		return "class/classReservation";
	}
	@GetMapping("/insertRes")
	public String insertResForm(Model model) {
		model.addAttribute("Reservation", new Reservation());
		
		return "Reservation/insertRes";
	}
	
	@PostMapping("/insertRes")
	public String insertRes(Reservation res, RedirectAttributes redirectAttributes) {
		long rseq = reservice.insertRes(res);
		redirectAttributes.addAttribute("rseq", rseq);
		return "redirect:/classChecking";
	}
	
	@GetMapping("/getRes")
	public String getRes(@RequestParam("rseq") long rseq, Reservation res, Model model) {
		res.setRseq(rseq);
		model.addAttribute("Reservation", reservice.getRes(res));
		return "class/classChecking";
	}
	
	
	@GetMapping("/classSchedule")
	public String classScheduleView() {
		
		return "class/classSchedule";
	}
	
	@GetMapping("/dietCalendar")
	public String dietCalendarView() {
		
		return "diet/dietCalendar";
	}
	
	@GetMapping("/getDiary")
	public String getDiary(@RequestParam("dseq") long dseq, DietDiary ddiary, Model model){
		System.out.println("dseq=" + dseq);
		ddiary.setDseq(dseq);
		model.addAttribute("DietDiary", ddiaryservice.getDietDiary(ddiary));
		
		return "diet/getDiary";
	}
	
	@GetMapping("/insertGetDiary")
	public String insertGetDiaryForm(Model model ,DietDiary ddiary) {
		model.addAttribute("insertGetDiary", new DietDiary());
		
		return "class/insertGetDiary";	
		
	}
	
	@PostMapping("/insertGetDiary")
	public String insertGetDiary(DietDiary ddiary,RedirectAttributes redirectAttributes) {
		
		System.out.println("Diary =" + ddiary);
		long dseq = ddiaryservice.insertDietDiary(ddiary);
		System.out.println("insertGetDiary() : dseq="+dseq);
		redirectAttributes.addAttribute("dseq", dseq);
		
		return "redirect:/getDiary";
	}
	
	@GetMapping("/howToClassCalendar")
	public String howToClassCalendarView() {
		
		return "class/howToClassCalendar";
	}
	
	@GetMapping("/classCalendar")
	public String classCalendarView() {
		
		return "class/classCalendar";
	}
	
	@GetMapping("/checkCalendar")
	public String checkCalendarView() {
		
		return "class/checkCalendar";
	}
	
	@GetMapping("/resCalendar")
	public String resCalendarView() {
		
		return "class/resCalendar";
	}
	
	@GetMapping("/insertClassDiary")
	public String insertClassDiaryForm(Model model) {
		model.addAttribute("insertClassDiary", new ClassDiary());
		
		return "class/insertClassDiary";	
		
	}
	
	@PostMapping("/insertClassDiary")
	public String insertClassDiary(ClassDiary cdiary, RedirectAttributes redirectAttributes) {
		cdiaryservice.insertcdiary(cdiary);
		long cdseq = cdiaryservice.insertcdiary(cdiary);
		redirectAttributes.addAttribute("cdseq", cdseq);
		return "redirect:classDiary";
	}
	
	
	
	
	
	
}
