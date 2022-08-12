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
		
		return (List<Board>) boardRepo.findAll();
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
		Board findBoard = boardRepo.findById(board.getBseq()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		
		boardRepo.save(findBoard);
		
	}
	
	@Override
	public void deleteBoard(Board board) {
		
		boardRepo.deleteById(board.getBseq());
	}
}
