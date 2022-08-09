package com.myFitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myFitness.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
