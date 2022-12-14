package com.myfitness.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="member")
@Entity
public class DietDiary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dseq;
	
	private String d_indate;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID" , nullable=false)
	@JsonManagedReference
	private Member member;
	private String breakfast;
	private String lunch;
	private String dinner;
	private String snack;
	private String weight;
	private String fat;
	private String muscle;
}
