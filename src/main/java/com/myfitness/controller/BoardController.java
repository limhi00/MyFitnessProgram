package com.myfitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.myfitness.domain.Board;
import com.myfitness.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 전체 게시글 목록
	@GetMapping("/allBoardList")
	public String allBoardList(Model model, Board board) {
		model.addAttribute("boardList", boardService.getBoardList(board));
		
		return "board/allBoardList";
	}

	// 게시글 상세
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		
		return "board/getBoard";
	}
	
	// 게시글 등록 폼
	@GetMapping("/insertBoard")
	public String insertBoardForm(Model model) {
		model.addAttribute("board", new Board());
		
		return "board/insertBoard";
	}
	
	// 게시글 등록
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		
		return "redirect:allBoardList";
	}
	
	// 게시글 수정 폼
	@GetMapping("/updateBoard")
	public String updateBoardForm(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		
		return "board/updateBoard";
	}
	
	// 게시글 수정
	@PostMapping("/updateBoard")
	public String boardUpdate(Board board) {
		boardService.updateBoard(board);
		
		return "redirect:/allBoardList";
	}
	
	// 게시글 삭제
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		
		return "redirect:allBoardList";
	}
}	
	
	

//	@GetMapping("/deleteBoardCheck")
//	public String deleteBoardCheckView() {
//		
//		return "board/deleteBoardCheck";
//	}
//}	
	
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
	
	