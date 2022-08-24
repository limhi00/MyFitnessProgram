package com.myfitness.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.myfitness.domain.Board;
import com.myfitness.domain.Category;
import com.myfitness.domain.Report;

public interface BoardService {

	/* board */
	
//	List<Board> getBoardList(Board board);
	
	Page<Board> getBoardList(Pageable pageable);
	
	Page<Board> getBoardSearchTitleList(String searchKeyword, Pageable pageable);
	
	Page<Board> getBoardSearchContList(String searchKeyword, Pageable pageable);

	Board getBoard(Board board);
	
	void insertBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);
	
	/* category */
	
	List<Category> getCategoryList(Category category);
	
	Category getCategory(Category category);
	
	void insertCategory(Category category);
	
	void updateCategory(Category category);
	
	void deleteCategory(Category category);
	
	/* report */
	
	Page<Report> getReportList(Pageable pageable);
	
	Report getReport(Report report);

	void insertReport(Report report);
	
	void updateReport(Report report);
	
	void deleteReport(Report report);
}