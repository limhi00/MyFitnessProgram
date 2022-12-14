package com.myfitness.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.myfitness.domain.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

	@Query(value = "SELECT * FROM reservation WHERE member_id = ?1", nativeQuery = true)
	public List<Reservation> getReservationList(String username);
	
	@Query(value = "SELECT name FROM member WHERE member_id = ?1", nativeQuery = true)
	public String getCTrainerName(String cTrainer);
	
	@Query(value = "SELECT * FROM reservation WHERE c_trainer = ?1", nativeQuery = true)
	public List<Reservation> getTrainerReservationList(String username);
}
