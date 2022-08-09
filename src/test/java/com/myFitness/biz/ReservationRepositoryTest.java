package com.myFitness.biz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myFitness.domain.ClassDiary;
import com.myFitness.domain.Reservation;
import com.myFitness.persistence.ClassDiaryRepository;
import com.myFitness.persistence.ReservationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationRepositoryTest {
	
	@Autowired
	private ReservationRepository resRepo;
	
	@Autowired
	private ClassDiaryRepository cdRepo;
	
	@Test
	public void testInsert() {
		Reservation res1 = new Reservation();
		res1.setResDate("2022년 08월 08일");
		
		resRepo.save(res1);
		
		ClassDiary cd1 = new ClassDiary();
		cd1.setRes(res1);
		cd1.setContent("res1에 대한 수업일지입니다.");
		
		cdRepo.save(cd1);
		
		Reservation res2 = new Reservation();
		res2.setResDate("2022년 08월 11일");
		
		resRepo.save(res2);
		
		ClassDiary cd2 = new ClassDiary();
		cd2.setRes(res2);
		cd2.setContent("res2에 대한 수업일지입니다.");
		
		cdRepo.save(cd2);
	}
}
