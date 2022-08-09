package com.myFitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myFitness.domain.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

}
