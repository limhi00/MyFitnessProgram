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
	public long insertDietDiary(DietDiary ddiary) {
		ddiary.setBreakfast(ddiary.getBreakfast());
		ddiary.setD_indate(ddiary.getD_indate());
		ddiary.setDinner(ddiary.getDinner());
		ddiary.setFat(ddiary.getFat());
		ddiary.setLunch(ddiary.getLunch());
		ddiary.setMuscle(ddiary.getMuscle());
		ddiary.setReview(ddiary.getReview());
		ddiary.setSnack(ddiary.getSnack());
		ddiary.setWaterdrink(ddiary.getWaterdrink());
		ddiary.setWeight(ddiary.getWeight());
		
		long dseq = dietrepo.save(ddiary).getDseq();
		
		return dseq;
	}
	
	@Override
	public DietDiary getDietDiary(DietDiary ddiary) {
		
		return dietrepo.findById(ddiary.getDseq()).get();
	}

}
