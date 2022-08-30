package com.myfitness;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myfitness.domain.ClassDiary;
import com.myfitness.domain.Reservation;
import com.myfitness.persistence.ClassDiaryRepository;
import com.myfitness.persistence.ReservationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationRepositoryTest {
//	@Autowired(required=true)
//	private MemberRepository memberRepo;
	
	@Autowired
	private ReservationRepository resRepo;
	
	@Autowired
	private ClassDiaryRepository cdRepo;
	
	private Reservation res;
	
	@Test
	public void testInsert() {
//		Member mem1 = new Member();
//		mem1.setMseq(1L);
//		mem1.setName("홍길동");
//		memberRepo.save(mem1);
		
		Reservation res1 = new Reservation();
//		res1.setMember(null);
		res1.setClassDate(dateFormat("20220716"));
		res1.setClassTime("12");
		resRepo.save(res1);
		
//		ClassDiary cd1 = new ClassDiary();
//		cd1.setRes(res1);
//		cd1.setContent("res1에 대한 수업일지입니다.");
//		cdRepo.save(cd1);
		
//		Member mem2 = new Member();
//		mem2.setMseq(2L);
//		mem2.setName("송송송");
//		memberRepo.save(mem2);
		
		Reservation res2 = new Reservation();
//		res2.setMember(null);
		res2.setClassDate(dateFormat("20220511"));
		res2.setClassTime("15");
		resRepo.save(res2);
		
//		ClassDiary cd2 = new ClassDiary();
//		cd2.setRes(res2);
//		cd2.setContent("res2에 대한 수업일지입니다.");
//		cdRepo.save(cd2);
	}
	
	// 'yyyyMMdd'형식을 Date형식으로 변환
	public Date dateFormat(String selectedDate) {
		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyyMMdd");
		Date tempDate = null;
		
		try {
			tempDate = beforeFormat.parse(selectedDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tempDate;
	}
}
