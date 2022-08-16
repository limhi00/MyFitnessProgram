package com.myfitness.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfitness.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {


}
