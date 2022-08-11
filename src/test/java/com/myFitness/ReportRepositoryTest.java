package com.myFitness;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myFitness.domain.Report;
import com.myFitness.persistence.ReportRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportRepositoryTest {
	
	@Autowired
	private ReportRepository reportrepo;
	
	@Test
	public void reportInsertTest() {
		
		for(int i=1; i<=10; i++) {
			Report repo = new Report();
			
			repo.setR_content("content"+i);
			repo.setR_indate(new Date());
			
			reportrepo.save(repo);
			
		}
	}

}
