package com.myfitness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.myfitness.domain.ClassDiary;
import com.myfitness.domain.Reservation;
import com.myfitness.persistence.ClassDiaryRepository;
import com.myfitness.persistence.ReservationRepository;
@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationRepository resRepo;
	
	@Autowired
	private ClassDiaryRepository cdRepo;

	@Override
	public List<Reservation> getReservationList(String username) {

		return resRepo.getReservationList(username);
	}

	@Override
	public Reservation getReservation(Long rseq) {
		
		return resRepo.findById(rseq).get();  
	}

	@Override
	public Long insertReservation(Reservation res) {
		
		res.setClassDate(res.getClassDate());
		Long rseq = resRepo.save(res).getRseq();
		
		return rseq;
	}

	@Override
	public void deleteReservation(Reservation res) {
		
		resRepo.deleteById(res.getRseq());
	}
	
}
