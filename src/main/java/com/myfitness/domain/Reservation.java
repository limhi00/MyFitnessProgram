package com.myfitness.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private Long rseq;
	
//	@ManyToOne
//	@JoinColumn(name="mid", nullable=false, updatable=false) 
//	private Member member;
	
	private Date classDate;
	
	private String classTime;
}
