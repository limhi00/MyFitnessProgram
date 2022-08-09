package com.myFitness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myFitness.domain.Board;
import com.myFitness.persistence.BoardRepository;

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
		
	}
	
	@Override
	public Board getBoard(Board board) {
	
		return null;
	}
	
	@Override
	public void updateBoard(Board board) {
		
	}
	
	@Override
	public void deleteBoard(Board board) {
		
	}
}
