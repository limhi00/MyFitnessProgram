package com.myFitness.persistence;

import org.springframework.data.repository.CrudRepository;

import com.myfitness.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
