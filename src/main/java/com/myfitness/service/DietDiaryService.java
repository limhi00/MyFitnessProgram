package com.myfitness.service;

import com.myfitness.domain.DietDiary;

public interface DietDiaryService {

	long insertDietDiary(DietDiary ddiary);

	DietDiary getDietDiary(DietDiary ddiary);

}
