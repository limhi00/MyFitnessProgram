package com.myfitness.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myfitness.domain.ClassDiary;
import com.myfitness.domain.DietDiary;
import com.myfitness.domain.Reservation;
import com.myfitness.service.ClassDiaryService;
import com.myfitness.service.DietDiaryService;
import com.myfitness.service.ReservationService;



@Controller
public class ClassController<getDiary> {
	

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
	public String classCancelView() {
		
		return "class/classCancel";
	}
	
	@GetMapping("/classChecking")
	public String classCheckingView() {
		
		return "class/classChecking";
	}
	
	@GetMapping("/classDiary")
	public String classDiaryView() {
		
		return "class/classDiary";
	}
	
	@GetMapping("/classReservation")
	public String classReservationView() {
		
		return "class/classReservation";
	}
	@PostMapping("/insertRes")
	public String insertResForm(Model model) {
		model.addAttribute("Reservation", new Reservation());
		
		return "Reservation/insertRes";
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
	public String getDiary(Model model, DietDiary ddiary){
		model.addAttribute("DietDiary", ddiaryservice.getDietDiary(ddiary));
		
		return "diet/getDiary";
	}
	
	@GetMapping("/insertGetDiary")
	public String insertGetDiaryForm(Model model) {
		model.addAttribute("getboard", new DietDiary());
		
		return "class/insertGetDiary";	
		
	}
	
	@PostMapping("/insertGetDiary")
	public String insertGetDiary(DietDiary ddiary) {
		ddiaryservice.insertDietDiary(ddiary);
		
		return "redirect:getDiary";
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
	public String insertClassDiary(ClassDiary cdiary) {
		cdiaryservice.insertcdiary(cdiary);
		
		return "redirect:classDiary";
	}
	
	
	
}
