package com.myFitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myFitness.domain.DietDiary;


public interface DietDiaryRepository extends CrudRepository<DietDiary, Long>{

}
