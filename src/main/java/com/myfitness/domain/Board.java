package com.myfitness.domain;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Board {
	@Id
	@GeneratedValue
	private Long bseq;
	
	private String title;
	private String writer;
	
	@Column(nullable = false) // null 값 비허용
	private String content;			  
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(updatable=false) 
	private Date createDate = new Date();

//	@Column(updatable = false, columnDefinition = "number default 0")
//	private Long cnt; // 조회수
	
	private String category;
	
	@ManyToOne
	@JoinColumn(name="mid", nullable=false, updatable=false)
	private Member member;
	
}
