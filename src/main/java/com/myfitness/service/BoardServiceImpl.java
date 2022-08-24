package com.myfitness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myfitness.domain.Board;
import com.myfitness.domain.Category;
import com.myfitness.domain.Report;
import com.myfitness.persistence.BoardRepository;
import com.myfitness.persistence.CategoryRepository;
import com.myfitness.persistence.ReportRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private CategoryRepository cateRepo;
	
	@Autowired
	private ReportRepository repRepo;
	
	@Override
//	public List<Board> getBoardList(Board board) {
//		
//		return boardRepo.findAll();
//		//return (List<Board>) boardRepo.findAll();
//	}
	
	public Page<Board> getBoardList(Pageable pageable) {
		
		return boardRepo.findAll(pageable);
	}
	
	public Page<Board> getBoardSearchTitleList(String searchKeyword, Pageable pageable) {
		
		return boardRepo.findByTitleContaining(searchKeyword, pageable);
	}
	
	public Page<Board> getBoardSearchContList(String searchKeyword, Pageable pageable) {
		
		return boardRepo.findByContentContaining(searchKeyword, pageable);
	}
	
	@Override
	public Board getBoard(Board board) {
	
		return boardRepo.findById(board.getBseq()).get();
	}
	
	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);
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
		
		boardRepo.deleteById(board.getBseq());
	}
	
	public List<Category> getCategoryList(Category category) {
		
		return cateRepo.findAll();
	}
	
	public Category getCategory(Category category) {
		
		return cateRepo.findById(category.getCid()).get();
	}
	
	public void insertCategory(Category category) {
		
		cateRepo.save(category);
	}
	
	public void updateCategory(Category category) {
		
		cateRepo.save(category);
	}
	
	public void deleteCategory(Category category) {
		
		cateRepo.deleteById(category.getCid());
	}
	
	public Page<Report> getReportList(Pageable pageable) {
		
		return repRepo.findAll(pageable);
	}
	
	public Report getReport(Report report) {
		
		return repRepo.findById(report.getRseq()).get();
	}
	
	public void insertReport(Report report) {
		
		repRepo.save(report);
	}
	
	public void updateReport(Report report) {
		
		repRepo.save(report);
	}
	
	public void deleteReport(Report report) {
		
		repRepo.deleteById(report.getRseq());
	}
}
