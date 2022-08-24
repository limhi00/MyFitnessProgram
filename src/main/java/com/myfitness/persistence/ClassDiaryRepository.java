package com.myfitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myfitness.domain.ClassDiary;

public interface ClassDiaryRepository extends CrudRepository<ClassDiary, Long> {

}
