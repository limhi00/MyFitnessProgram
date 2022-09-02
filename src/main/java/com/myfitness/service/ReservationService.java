package com.myfitness.service;


import com.myfitness.domain.Reservation;

public interface ReservationService {
	
	long insertRes(Reservation res);

	Reservation getRes(Reservation res);

	void deleteRes(Reservation res);

}
