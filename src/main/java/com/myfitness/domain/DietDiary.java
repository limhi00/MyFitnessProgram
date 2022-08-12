package com.myfitness.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class DietDiary {
	
	@Id
	@GeneratedValue
	private Long dseq;
	@ManyToOne
	@JoinColumn(name = "mid" , nullable=false)
	private Member member;
	private String	breakfast;
	private String	lunch;
	private String	dinner;
	private String	snack;
	private String	waterdrink;
	private String	weight;
	private String	fat;
	private String	muscle;
	private String	review;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date	d_indate;
	
	

}
