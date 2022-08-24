package com.myfitness.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.myfitness.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
	
	Page<Board> findByContentContaining(String searchKeyword, Pageable pageable);
}
