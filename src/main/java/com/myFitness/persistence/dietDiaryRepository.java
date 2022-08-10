package com.myFitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myFitness.domain.DietDiary;


public interface dietDiaryRepository extends CrudRepository<DietDiary, Long>{

}
