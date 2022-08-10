package com.myFitness.biz;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myFitness.domain.Board;
import com.myFitness.persistence.BoardRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class boardControllerTest {
	
	@Autowired 
	private BoardRepository boardRepo;
	
	@Test
	public void boardInsertTest() {
		for(int i=1; i<=10; i++) {
			Board board = new Board();
			//board.setSeq(1L);
			board.setTitle("ㅎㅇㅎㅇ " + i);
			board.setWriter("테스트멤버");
			board.setContent("테스트내용 " + i);
			board.setCreateDate(null);
			board.setCnt(0L);
			board.setUp(0L);
			
			boardRepo.save(board);
		}
	}

}
