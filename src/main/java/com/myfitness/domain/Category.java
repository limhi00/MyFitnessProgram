package com.myfitness.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long cid;
	
	@Column(unique = true)
	private String name;
	
//	@OneToMany(mappedBy = "category")
//	private List<Board> BoardList = new ArrayList<>();

//	public void mappingBoard(Board board) {
//		this.BoardList.add(board);
//	}
}
