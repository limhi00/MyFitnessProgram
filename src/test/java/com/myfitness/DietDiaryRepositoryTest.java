package com.myfitness;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myfitness.domain.DietDiary;
import com.myfitness.persistence.DietDiaryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DietDiaryRepositoryTest {
	
	@Autowired
	private DietDiaryRepository ddiaryrepo;
	
	@Test
	public void ddiaryInsertTest(){
		

		for(int i=1; i<=10; i++) {
			DietDiary ddiary = new DietDiary();
			
			ddiary.setBreakfast("사과" +i);
			ddiary.setLunch("사과" +i);
			ddiary.setDinner("사과" +i);
			ddiary.setSnack("사과" +i);
			ddiary.setWaterdrink("사과" +i);
			ddiary.setWeight("사과" +i);
			ddiary.setFat("사과" +i);
			ddiary.setMuscle("사과" +i);
			ddiary.setReview("사과" +i);
			ddiary.setD_indate(new Date());
			
			ddiaryrepo.save(ddiary);
			
			
		}
	}
}
