package com.myFitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myFitness.domain.Report;


public interface reportRepository extends CrudRepository<Report, Long> {

}
