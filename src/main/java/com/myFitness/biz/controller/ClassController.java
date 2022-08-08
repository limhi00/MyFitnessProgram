package com.myFitness.biz.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ClassController {

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
	
	@GetMapping("/classSchedule")
	public String classScheduleView() {
		
		return "class/classSchedule";
	}
	
	@GetMapping("/dietCalendar")
	public String dietCalendarView() {
		
		return "class/dietCalendar";
	}
	
	@GetMapping("/getDiary")
	public String getDiaryView() {
		
		return "class/getDiary";
	}
	
	@GetMapping("/howToClassCalendar")
	public String howToClassCalendarView() {
		
		return "class/howToClassCalendar";
	}
	
	@GetMapping("/classCalendar")
	public String classCalendarView() {
		
		return "class/classCalendar";
	}
	
	
	
}
