package com.myfitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfitness.domain.Board;
import com.myfitness.domain.Reservation;
import com.myfitness.persistence.ReservationRepository;
@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationRepository resrepo;
	
	@Override
	public void insertRes(Reservation res) {
		
		resrepo.save(res);
	}
	@Override
	public Reservation getRes(Reservation res) {
		
		return resrepo.findById(res.getRseq()).get();
	}
	@Override
	public void deleteRes(Reservation res) {
		
		resrepo.deleteById(res.getRseq());
	}
}
