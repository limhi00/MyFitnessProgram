package com.myfitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myfitness.domain.Report;


public interface ReportRepository extends CrudRepository<Report, Long> {

}
