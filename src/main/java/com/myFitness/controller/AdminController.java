package com.myFitness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/deleteCategory")
	public String deleteCategoryView() {
		
		return "admin/deleteCategory";
	}

	@GetMapping("/insertCategory")
	public String insertCategoryView() {
		
		return "admin/insertCategory";
	}
	
	@GetMapping("/updateCategory")
	public String updateCategoryView() {
		
		return "admin/updateCategory";
	}

	@GetMapping("/trainerManagement")
	public String trainerManagementView() {
		
		return "admin/trainerManagement";
	}
	
	
	@GetMapping("/userManagement")
	public String userManagementView() {
		
		return "admin/userManagement";
	}
	
}
