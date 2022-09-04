package com.myfitness.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable=false, updatable=false) 
	private Member member;
	
	private Date classDate;
	
	private String[] classTime = {"09:00 ~ 09:50", "10:00 ~ 10:50"};
	
	private int phonenum;
	
}
