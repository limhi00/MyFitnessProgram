package com.myFitness.domain;

import java.text.SimpleDateFormat;
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
	private int rseq;
	
//	@ManyToOne
//	@JoinColumn(name="MEMBER_ID", nullable=false, updatable=false) 
//	private Member member;
	
	private String resDate;
	
	public String strDate(Date selectedDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		String strDate = dateFormat.format(selectedDate.getTime());
		
		return strDate;
	}
}
