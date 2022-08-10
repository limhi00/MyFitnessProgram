package com.myFitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myFitness.domain.Report;


public interface ReportRepository extends CrudRepository<Report, Long> {

}
