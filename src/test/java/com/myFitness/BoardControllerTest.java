package com.myFitness;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myFitness.domain.Board;
import com.myFitness.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardControllerTest {
	
	@Autowired 
	private BoardRepository boardRepo;

	@Test
	public void boardInsertTest() {
		for(int i=1; i<=10; i++) {
			Board board = new Board();
			board.setTitle("안녕하세요." + i);
			board.setWriter("장동규");
			board.setContent("테스트내용 " + i);
			board.setCnt(0L);
			board.setCreateDate(LocalDateTime.now()); // 2022-08-10 14:33:51.838953 
			
			boardRepo.save(board);
		}
	}
}
