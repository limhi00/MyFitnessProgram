package com.myFitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myFitness.domain.ClassDiary;

public interface ClassDiaryRepository extends CrudRepository<ClassDiary, Integer> {

}
