package com.myFitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myFitness.domain.Board;
import com.myFitness.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/allBoardList")
	public String allBoardList(Model model, Board board) {
		
		List<Board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList", boardList);
		
		return "board/allBoardList";
	}

//	@GetMapping("/allBoardList")
//	public String allBoardListView() {
//		
//		return "board/allBoardList";
//	}
	
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
	

	
}
