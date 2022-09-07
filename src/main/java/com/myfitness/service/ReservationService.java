package com.myfitness.service;


import java.util.List;

import com.myfitness.domain.ClassDiary;
import com.myfitness.domain.Member;
import com.myfitness.domain.Reservation;

public interface ReservationService {
	
	List<Reservation> getReservationList(String username);
	
	Reservation getReservation(Long rseq);
	
	Long insertReservation(Reservation res);
	
	List<Member> getCTrainerList(String role);
	
	String getCTrainerName(String cTrainer);
	
	void deleteReservation(Reservation res);
	
	ClassDiary getClassDiary(Long rseq);
	
	ClassDiary findClassDiary(Reservation res);
	
	ClassDiary getClassDiaryCdseq(Long cdseq);
	
	void insertClassDiary(ClassDiary cDiary);
	
	List<Reservation> getTrainerReservationList(String username);
}
