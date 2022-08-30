package com.myfitness.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myfitness.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Category findByName(String name);

}
