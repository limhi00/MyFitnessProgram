package com.myFitness.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	@JoinColumn(name="MEMBER_SEQ", nullable=false, updatable=false) 
	private Member member;
	
	private Date resDate;
	
	// 'yyyyMMdd'형식을 Date형식으로 변환
	public Date dateFormat(String selectedDate) {
		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyyMMdd");
		Date tempDate = null;
		
		try {
			tempDate = beforeFormat.parse(selectedDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tempDate;
	}
	
	// Date형식을 'yyyy년 MM월 dd일'형식으로 변환
	public String stringFormat(Date selectedDate) {
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-MM-dd");
		String tempDate = null;
		
		tempDate = afterFormat.format(selectedDate);
		
		return tempDate;
	}
}
