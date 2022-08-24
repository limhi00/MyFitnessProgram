package com.myfitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfitness.domain.DietDiary;
import com.myfitness.persistence.DietDiaryRepository;
@Service
public class DietDiaryServiceImpl implements DietDiaryService {
	
	@Autowired
	private DietDiaryRepository dietrepo;
	
	@Override
	public void insertDietDiary(DietDiary ddiary) {
		dietrepo.save(ddiary);
	}
	
	@Override
	public DietDiary getDietDiary(DietDiary ddiary) {
		
		return dietrepo.findById(ddiary.getDseq()).get();
	}

}
