package com.myfitness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myfitness.domain.Board;
import com.myfitness.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepo;
	
	@Override
	public List<Board> getBoardList(Board board) {
		
		return boardRepo.findAll();
		//return (List<Board>) boardRepo.findAll();
	}
	
	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	
	@Override
	public Board getBoard(Board board) {
	
		return boardRepo.findById(board.getBseq()).get();
	}
	
	@Override
	public void updateBoard(Board board) {
		boardRepo.save(board);
		
//		// 수정할 게시글 조회
//		Board findBoard = boardRepo.findById(board.getBseq()).get();
//		
//		// board - 화면에서 입력된 데이터
//		findBoard.setTitle(board.getTitle());
//		findBoard.setCategory(board.getCategory());
//		findBoard.setContent(board.getContent());
//		findBoard.setTitle(board.getWriter());
//		
//		boardRepo.save(findBoard);
		
		}
	
	@Override
	public void deleteBoard(Board board) {
		// boardRepo.delete(board);
		boardRepo.deleteById(board.getBseq());
	}
}
