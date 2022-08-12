package com.myfitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myfitness.domain.DietDiary;


public interface DietDiaryRepository extends CrudRepository<DietDiary, Long>{

}
