package com.myfitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfitness.domain.Report;
import com.myfitness.persistence.ReportRepository;
@Service
public class reportServiceImpl implements ReportService {
	
	@Autowired
	private ReportRepository reportrepo;
	
	@Override
	public void insertreport(Report report) {
		
		reportrepo.save(report);
	}
	@Override
	public Report getReport(Report report) {
		
		return reportrepo.findById(report.getRseq()).get();
	}
}
