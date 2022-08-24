package com.myfitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfitness.domain.ClassDiary;
import com.myfitness.persistence.ClassDiaryRepository;

@Service
public class ClassDiaryServiceImpl implements ClassDiaryService {
	
	@Autowired
	private ClassDiaryRepository cdrepo;
	
	@Override
	public void insertcdiary(ClassDiary cdiary) {
		
		cdrepo.save(cdiary);
	}
	
	@Override
	public ClassDiary getcdiary(ClassDiary cdiDiary) {
		
		return cdrepo.findById(cdiDiary.getCdseq()).get();
	}
}
