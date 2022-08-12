 package com.myfitness;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myfitness.domain.Board;
import com.myfitness.persistence.BoardRepository;


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
			board.setCategory("전체게시판");
			board.setWriter("홍길동");
			board.setContent("테스트내용 " + i); 
			board.setCreateDate(new Date());

			
			boardRepo.save(board);

		}
	}

}