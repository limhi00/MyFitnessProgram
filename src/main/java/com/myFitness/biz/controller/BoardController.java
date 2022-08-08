package com.myFitness.biz.controller;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BoardController {

	@GetMapping("/allBoardList")
	public String allBoardListView() {
		
		return "board/allBoardList";
	}
	
	@GetMapping("/challengeBoardList")
	public String challengeBoardListView() {
		
		return "board/challengeBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoardView() {
		
		return "board/deleteBoard";
	}
	
	@GetMapping("/deleteBoardCheck")
	public String deleteBoardCheckView() {
		
		return "board/deleteBoardCheck";
	}
	
	@GetMapping("/freeBoardList")
	public String freeBoardListView() {
		
		return "board/freeBoardList";
	}
	
	@GetMapping("/getBoard")
	public String gerBoardView() {
		
		return "board/getBoard";
	}
	
	@GetMapping("/getNoticeBoard")
	public String getNoticeBoardView() {
		
		return "board/getNoticeBoard";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		
		return "board/insertBoard";
	}
	
//	@PostMapping("/insertBoard")
//	public String insertBoard() {
//		
//		boardService.insertBoard(board);
//		
//		return "redirect:board/allBoardList";
//	}
	
	@GetMapping("/noticeBoardList")
	public String noticeBoardListView() {
		
		return "board/noticeBoardList";
	}
	
	@GetMapping("/reportPage")
	public String reportPageView() {
		
		return "board/reportPage";
	}
	
	@GetMapping("/updateBoard")
	public String updateBoardView() {
		
		return "board/updateBoard";
	}
	
	@GetMapping("/videoBoardList")
	public String videoBoardListView() {
		
		return "board/videoBoardList";
	}
	
	@GetMapping("/reportBoardList")
	public String reportBoardListView() {
		
		return "board/reportBoardList";
	}
	
	@GetMapping("/categoryList")
	public String categoryListView() {
		
		return "board/categoryList";
	}
	
}
