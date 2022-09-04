package com.myfitness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfitness.domain.DietDiary;
import com.myfitness.persistence.DietDiaryRepository;

@Service
public class DietDiaryServiceImpl implements DietDiaryService {
	
	@Autowired
	private DietDiaryRepository dietRepo;
	
	public List<DietDiary> getDiaryList(String username) {
		
		return dietRepo.getDietDiaryList(username);
	}
	
	public DietDiary getDiary(Long dseq) {
		
		return dietRepo.findById(dseq).get();
	}
	
	public Long insertDiary(DietDiary ddiary) {
		
		ddiary.setD_indate(ddiary.getD_indate());
		Long Dseq = dietRepo.save(ddiary).getDseq();
		
		return Dseq;
	}
	
	public void updateDiary(DietDiary ddiary) {
		
		dietRepo.save(ddiary);
	}
	
//	@Override
//	public long insertDietDiary(DietDiary ddiary) {
//		ddiary.setBreakfast(ddiary.getBreakfast());
//		ddiary.setDinner(ddiary.getDinner());
//		ddiary.setFat(ddiary.getFat());
//		ddiary.setLunch(ddiary.getLunch());
//		ddiary.setMuscle(ddiary.getMuscle());
//		ddiary.setSnack(ddiary.getSnack());
//		ddiary.setWeight(ddiary.getWeight());
//
//		ddiary.setD_indate(ddiary.getD_indate());
//		
//		long dseq = dietrepo.save(ddiary).getDseq();
//		
//		return dseq;
//	}
//	
//	@Override
//	public DietDiary getDietDiary(DietDiary ddiary) {
//		
//		return dietrepo.findById(ddiary.getDseq()).get();
//	}

}
