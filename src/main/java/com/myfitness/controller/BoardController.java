package com.myfitness.controller;

import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;

import com.myfitness.domain.Board;
import com.myfitness.domain.Category;
import com.myfitness.domain.Report;
import com.myfitness.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/allBoardList")
	public String allBoardList(Model model, Category category,
			@PageableDefault(page=0, size=20, sort="bseq", direction=Sort.Direction.DESC) Pageable pageable,
			Long searchCategory, String searchSelect, String searchKeyword) {
		
		List<Category> categoryList = boardService.getCategoryList(category);
		
		Page<Board> boardList = null;
		
		if(searchCategory == null || searchCategory.equals(0L)) {
			if(searchSelect == null) {
				boardList = boardService.getBoardList(pageable);
				System.out.println("searchCategory = " + searchCategory +", searchSelect = " + searchSelect + ", searchKeyword = " + searchKeyword);
			} else {
				if(searchSelect.equals("title")) {
					if(searchKeyword == null) {
						boardList = boardService.getBoardList(pageable);
						System.out.println("searchCategory = " + searchCategory +", searchSelect = " + searchSelect + ", searchKeyword = " + searchKeyword);
					} else {
						boardList = boardService.getBoardSearchTitleList(searchKeyword, pageable);
						System.out.println("searchCategory = " + searchCategory +", searchSelect = " + searchSelect + ", searchKeyword = " + searchKeyword);
					}
				} else if(searchSelect.equals("content")) {
					if(searchKeyword == null) {
						boardList = boardService.getBoardList(pageable);
						System.out.println("searchCategory = " + searchCategory +", searchSelect = " + searchSelect + ", searchKeyword = " + searchKeyword);
					} else {
						boardList = boardService.getBoardSearchContList(searchKeyword, pageable);
						System.out.println("searchCategory = " + searchCategory +", searchSelect = " + searchSelect + ", searchKeyword = " + searchKeyword);
					}
				} else {
					boardList = boardService.getBoardList(pageable);
					System.out.println("searchCategory = " + searchCategory +", searchSelect = " + searchSelect + ", searchKeyword = " + searchKeyword);
				}
			}
		} else {
			if(searchSelect == null) {
				boardList = boardService.getCategoryBoardList(searchCategory, pageable);
				System.out.println("searchCategory = " + searchCategory +", searchSelect = " + searchSelect + ", searchKeyword = " + searchKeyword);
			} else {
				if(searchSelect.equals("title")) {
					if(searchKeyword.equals("")) {
						System.out.println("searchCategory = " + searchCategory +", searchSelect = " + searchSelect + ", searchKeyword = " + searchKeyword);
						boardList = boardService.getCategoryBoardList(searchCategory, pageable);
					} else {
						System.out.println("searchCategory = " + searchCategory +", searchSelect = " + searchSelect + ", searchKeyword = " + searchKeyword);
						boardList = boardService.getCategoryBoardSearchTitleList(searchCategory, searchKeyword, pageable);
					}
				} else if(searchSelect.equals("content")) {
					if(searchKeyword == null) {
						System.out.println("searchCategory = " + searchCategory +", searchSelect = " + searchSelect + ", searchKeyword = " + searchKeyword);
						boardList = boardService.getCategoryBoardList(searchCategory, pageable);
					} else {
						System.out.println("searchCategory = " + searchCategory +", searchSelect = " + searchSelect + ", searchKeyword = " + searchKeyword);
						boardList = boardService.getCategoryBoardSearchContList(searchCategory, searchKeyword, pageable);
					}
				} else {
					System.out.println("searchCategory = " + searchCategory +", searchSelect = " + searchSelect + ", searchKeyword = " + searchKeyword);
					boardList = boardService.getCategoryBoardList(searchCategory, pageable);
				}
			}
		}
		
		int nowPage = boardList.getPageable().getPageNumber() + 1;
		int startPage = Math.max(nowPage - 9, 1);
		int endPage = Math.min(nowPage +5, boardList.getTotalPages());
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("boardList", boardList);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "board/allBoardList";
	}
	
	// ????????? ??????
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		
		model.addAttribute("board", boardService.getBoard(board));
		
		return "board/getBoard";
	}
	
	// ????????? ?????? ???
	@RequestMapping("/insertBoardView")
	public String insertBoardForm(Model model, Category category) {
		
		model.addAttribute("categoryList", boardService.getCategoryList(category));
		
		return "board/insertBoard";
	}
	
	// ????????? ??????
	@RequestMapping("/insertBoard")
	public String insertBoard(Board board, MultipartFile file) throws Exception {
		
		boardService.writeBoard(board, file);
		
		return "redirect:/allBoardList";
	}
	
	// ????????? ?????? ???
	@GetMapping("/updateBoard")
	public String updateBoardForm(Board board, Category category, Model model) {
		
		model.addAttribute("board", boardService.getBoard(board));
		model.addAttribute("categoryList", boardService.getCategoryList(category));
		
		return "board/updateBoard";
	}
	
	// ????????? ??????
	@PostMapping("/updateBoard")
	public String updateBoard(Board board, MultipartFile file) throws Exception {
		
		boardService.writeBoard(board, file);
		
		return "redirect:/allBoardList";
	}
	
	// ????????? ?????? ???
	@RequestMapping("/deleteBoardView")
	public String deleteBoard(Board board, Model model) {
		
		model.addAttribute("board", boardService.getBoard(board));
		
		return "board/deleteBoard";
	}
	
	// ????????? ?????? ?????? ??????
	@RequestMapping("/deleteBoardCheck")
	public void deleteBoardCheck(Board board) {
		
		boardService.deleteBoard(board);
	}
	
	// ????????? ?????? ???
	@GetMapping("/reportPageView")
	public String reportBoardView(Board board, Model model) {
		
		model.addAttribute("board", boardService.getBoard(board));
		
		return "board/reportPage";
	}
	
	@PostMapping("/reportPage")
	public String reportBoard(Report report) {
		
		boardService.insertReport(report);
		
		return "board/reportResult";
	}

}	
