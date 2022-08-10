package com.myFitness.domain;

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
public class Report {
	
	@Id
	@GeneratedValue
	private Long rseq;
	@ManyToOne
	@JoinColumn(name = "bseq" , nullable=false)
	private Board board;
	@ManyToOne
	@JoinColumn(name = "id" , nullable=false)
	private Member member;
	private String r_content;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date r_indate;
	
	

}
