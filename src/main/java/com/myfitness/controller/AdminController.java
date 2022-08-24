package com.myfitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myfitness.domain.Category;
import com.myfitness.domain.Report;
import com.myfitness.service.BoardService;

@Controller
public class AdminController {
	
	@Autowired
	private BoardService boardService;
	
	// 카테고리 목록
	@GetMapping("/categoryList")
	public String categoryList(Model model, Category category) {
		
		model.addAttribute("categoryList", boardService.getCategoryList(category));
		
		return "admin/categoryList";
	}

	// 카테고리 등록 뷰
	@RequestMapping("/insertCategoryView")
	public String insertCategoryView() {
		
		return "admin/insertCategory";
	}
	
	// 카테고리 등록
	@PostMapping("/insertCategory")
	public String insertCategory(Category category) {
		
		boardService.insertCategory(category);
		
		return "admin/insertCateResult";
	}
	
	// 카테고리 삭제 뷰
	@RequestMapping("/deleteCategoryView")
	public String deleteCategoryView(Model model, Category category) {
		
		model.addAttribute("category", boardService.getCategory(category));
		
		return "admin/deleteCategory";
	}
	
	// 카테고리 삭제
	@RequestMapping("/deleteCategory")
	public String deleteCategory(Category category) {
		
		boardService.deleteCategory(category);
			
		return "admin/deleteCateResult";
	}

	// 신고글 목록
	@RequestMapping("/reportBoardList")
	public String reportBoardList(Model model, @PageableDefault(page=0, size=10, sort="rseq", direction=Sort.Direction.DESC) Pageable pageable) {
		
		Page<Report> reportList = boardService.getReportList(pageable);
		
		int nowPage = reportList.getPageable().getPageNumber() +1 ;
		int startPage = Math.max(nowPage - 9, 1);
		int endPage = Math.min(nowPage + 10, reportList.getTotalPages());
		
		model.addAttribute("reportList", reportList);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "admin/reportBoardList";
	}
	
	@RequestMapping("/reportView")
	public String reportView(Model model, Report report) {
		
		model.addAttribute("report", boardService.getReport(report));
		
		return "admin/reportView";
	}

	// 트레이너 관리
	@GetMapping("/trainerManagement")
	public String trainerManagementView() {
		
		return "admin/trainerManagement";
	}
	
	// 회원 관리
	@GetMapping("/userManagement")
	public String userManagementView() {
		
		return "admin/userManagement";
	}
	
}
