 package com.myfitness;


import java.util.Date;


import org.junit.Ignore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.myfitness.domain.Board;
import com.myfitness.domain.Category;
import com.myfitness.domain.Report;
import com.myfitness.persistence.BoardRepository;
import com.myfitness.persistence.CategoryRepository;
import com.myfitness.persistence.ReportRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardControllerTest {
	
	@Autowired 
	private BoardRepository boardRepo;
	@Autowired
	private CategoryRepository cateRepo;
	@Autowired
	private ReportRepository repRepo;
	
	@Test
	public void boardInsertTest() {
		Category cate1 = new Category();
		cate1.setName("공지사항");
		cateRepo.save(cate1);
		
		Category cate2 = new Category();
		cate2.setName("자유게시판");
		cateRepo.save(cate2);
		
		Category cate3 = new Category();
		cate3.setName("운동영상");
		cateRepo.save(cate3);
		
		Category cate4 = new Category();
		cate4.setName("챌린지");
		cateRepo.save(cate4);
		
		for(int i=1; i<=20; i++) {
			Board board = new Board();
			board.setTitle("안녕하세요." + i);
			board.setCategory(cate1);
			board.setWriter("운영자");
			board.setContent("테스트내용 " + i);
			board.setBoardPwd("0000");

			boardRepo.save(board);
		}
		for(int i=1; i<=20; i++) {
			Board board = new Board();
			board.setTitle("반갑습니다." + i);
			board.setCategory(cate2);
			board.setWriter("송송송");
			board.setContent("테스트내용 " + i);
			board.setBoardPwd("0000");

			boardRepo.save(board);
		}
		for(int i=1; i<=20; i++) {
			Board board = new Board();
			board.setTitle("안녕하세요." + i);
			board.setCategory(cate3);
			board.setWriter("김김김");
			board.setContent("테스트내용 " + i);
			board.setBoardPwd("1234");

			boardRepo.save(board);
		}
		for(int i=1; i<=20; i++) {
			Board board = new Board();
			board.setTitle("안녕히계세요." + i);
			board.setCategory(cate4);
			board.setWriter("박박박");
			board.setContent("테스트내용 " + i);
			board.setBoardPwd("5555");

			boardRepo.save(board);
		}
	}
	
	@Test
	@Ignore
	public void reportInsertTest() {
		for(int i=1; i<=20; i++) {
			Report report = new Report();
			report.setRTitle("신고제목" + i);
			report.setRContent(i + "번째 신고내용입니다");
			repRepo.save(report);
		}
	}

}
