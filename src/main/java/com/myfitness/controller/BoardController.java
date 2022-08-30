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
	
	// 전체 게시글 목록
//	@GetMapping("/allBoardList")
//	public String allBoardList(Model model, Board board) {
//		model.addAttribute("boardList", boardService.getBoardList(board));
//		
//		return "board/allBoardList";
//	}
	
	@GetMapping("/allBoardList")
	public String allBoardList(Model model, Category category,
							   @PageableDefault(page=0, size=20, sort="bseq", direction=Sort.Direction.DESC) Pageable pageable,
							   String searchSelect, String searchKeyword) {
		Page<Board> boardList = null;
		
		if(searchSelect == null) {
			boardList = boardService.getBoardList(pageable);
		} else {
			if(searchSelect.equals("title")) {
				if(searchKeyword == null) {
					boardList = boardService.getBoardList(pageable);
				} else {
					boardList = boardService.getBoardSearchTitleList(searchKeyword, pageable);
				}
			} else if(searchSelect.equals("content")) {
				if(searchKeyword == null) {
					boardList = boardService.getBoardList(pageable);
				} else {
					boardList = boardService.getBoardSearchContList(searchKeyword, pageable);
				}
			} else {
				boardList = boardService.getBoardList(pageable);
			}
		}
		
		int nowPage = boardList.getPageable().getPageNumber() + 1;
		int startPage = Math.max(nowPage - 9, 1);
		int endPage = Math.min(nowPage +5, boardList.getTotalPages());
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "board/allBoardList";
	}
	
//	// 공지사항 게시글 목록
//	@GetMapping("/noticeBoardList")
//	public String noticeBoardList(Model model, Category category,
//			   @PageableDefault(page=0, size=20, sort="bseq", direction=Sort.Direction.DESC) Pageable pageable,
//			   String searchSelect, String searchKeyword) {
//		
//		Page<Board> boardList = boardService.getCategoryBoardList(category, pageable);
//		
//		int nowPage = boardList.getPageable().getPageNumber() + 1;
//		int startPage = Math.max(nowPage - 9, 1);
//		int endPage = Math.min(nowPage +5, boardList.getTotalPages());
//		
//		model.addAttribute("boardList", boardList);
//		model.addAttribute("nowPage", nowPage);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		
//		return "board/noticeBoardList";
//	}
	
	// 자유게시판 게시글 목록
	@GetMapping("/freeBoardList")
	public String freeBoardList(Model model, Category category,
			@PageableDefault(page=0, size=20, sort="bseq", direction=Sort.Direction.DESC) Pageable pageable,
			String searchSelect, String searchKeyword) {
		
		List<Category> categoryList = boardService.getCategoryList(category);
		
		Page<Board> boardList = null;
		
		if(searchSelect == null) {
			boardList = boardService.getBoardList(pageable);
		} else {
			if(searchSelect.equals("title")) {
				if(searchKeyword == null) {
					boardList = boardService.getBoardList(pageable);
				} else {
					boardList = boardService.getBoardSearchTitleList(searchKeyword, pageable);
				}
			} else if(searchSelect.equals("content")) {
				if(searchKeyword == null) {
					boardList = boardService.getBoardList(pageable);
				} else {
					boardList = boardService.getBoardSearchContList(searchKeyword, pageable);
				}
			} else {
				boardList = boardService.getBoardList(pageable);
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
		
		return "board/freeBoardList";
	}
	
//	// 운동영상 게시판 게시글 목록
//	@GetMapping("/videoBoardList")
//	public String videoBoardList(Model model, @PageableDefault(page=0, size=20, sort="bseq", direction=Sort.Direction.DESC) Pageable pageable) {
//		model.addAttribute("boardList", boardService.getBoardList(pageable));
//		
//		return "board/videoBoardList";
//	}
//	
//	// 챌린지 게시판 게시글 목록
//	@GetMapping("/challengeBoardList")
//	public String challengeBoardList(Model model, @PageableDefault(page=0, size=20, sort="bseq", direction=Sort.Direction.DESC) Pageable pageable) {
//		model.addAttribute("boardList", boardService.getBoardList(pageable));
//		
//		return "board/challengeBoardList";
//	}

	// 게시글 상세
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		
		model.addAttribute("board", boardService.getBoard(board));
		
		return "board/getBoard";
	}
	
	// 게시글 등록 폼
	@GetMapping("/insertBoard")
	public String insertBoardForm(Model model, Category category) {
		
		model.addAttribute("categoryList", boardService.getCategoryList(category));
		
		return "board/insertBoard";
	}
	
	// 게시글 등록
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, MultipartFile file) throws Exception {
		
		boardService.writeBoard(board, file);
		
		return "redirect:/allBoardList";
	}
	
	// 게시글 수정 폼
	@GetMapping("/updateBoard")
	public String updateBoardForm(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		
		return "board/updateBoard";
	}
	
	// 게시글 수정
	@PostMapping("/updateBoard")
	public String updateBoard(Board board, MultipartFile file) throws Exception {
		
		boardService.writeBoard(board, file);
		
		return "redirect:/allBoardList";
	}
	
	// 게시글 삭제 뷰
	@RequestMapping("/deleteBoardView")
	public String deleteBoard(Board board, Model model) {
		
		model.addAttribute("board", boardService.getBoard(board));
		
		return "board/deleteBoard";
	}
	
	// 게시글 삭제 확인 처리
	@RequestMapping("/deleteBoardCheck")
	public void deleteBoardCheck(Board board) {
		
		boardService.deleteBoard(board);
	}
	
	// 게시글 신고 뷰
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

	
//	@GetMapping("/board/getBoard/{bseq}")
//	public String getBoardView(@ModelAttribute("member") Member member,
//						Board board, Model model) {
//		
//		if (member.getMid() == null) {
//			return "redirect:login";
//		}
//		
//		boardService.getBoard(board);
//		
//		model.addAttribute("board", boardService.getBoard(board));
//		
//		return "board/getBoard";
//	}
	
//	@GetMapping("/board/getBoard/{bseq}")
//	public String getBoard(@PathVariable("bseq") Long bseq, Model model) {
		
//		if (member.getMid() == null) {
//			return "redirect:login";
//		}
		
//		boardService.getBoard(board);
//		
//		model.addAttribute("board", boardService.getBoard(board));
		
//		return "board/getBoard";
//	}
	
//	@GetMapping("/board/getBoard")
//	public String getBoardvdsvds(@PathVariable("bseq") Long bseq, Model model) {
		
//		if (member.getMid() == null) {
//			return "redirect:login";
//		}
		
//		boardService.getBoard(board);
//		
//		model.addAttribute("board", boardService.getBoard(board));
		
//		return "board/getBoard";
//	}
	

	
//	@PostMapping("/insertBoard")
//	public String insertBoard(@ModelAttribute("member") Member member, Board board) {
//		
////		if (member.getMid() == null) {
////			return "redirect:login";
////		}
//		
//		boardService.insertBoard(board);
//		
//		return "redirect:board/allBoardList";
//	}
	
	