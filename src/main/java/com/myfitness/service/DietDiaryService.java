package com.myfitness.service;

import java.util.List;

import com.myfitness.domain.DietDiary;

public interface DietDiaryService {

	List<DietDiary> getDiaryList(String username);
	
	DietDiary getDiary(Long dseq);
	
	Long insertDiary(DietDiary ddiary);

	void updateDiary(DietDiary ddiary);
}
