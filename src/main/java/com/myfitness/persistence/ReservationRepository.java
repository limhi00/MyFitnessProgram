package com.myfitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myfitness.domain.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
