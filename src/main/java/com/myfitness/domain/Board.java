package com.myfitness.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Data;


@Data
@Entity
//@SequenceGenerator(
//		name = "BOARD_SEQ_GENERATOR",
//		sequenceName = "BOARD_SEQ")
public class Board {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,
	//				generator = "BOARD_SEQ_GENERATOR")
	@GeneratedValue
	private Long bseq;
	
	private String title;
	
	@Column(updatable = false)
	private String writer;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	@Column(insertable = false, updatable = false, columnDefinition = "number default 0")
	private Long up = 0L; // 추천수
	
	@CreationTimestamp
	@Column(name = "createdate", updatable = false)
	private LocalDateTime createDate; // 생성일자

	@Column(updatable = false, columnDefinition = "number default 0")
	private Long cnt = 0L; // 조회수
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable=false, updatable=false)
	private Member member;
	
	//public void setMember(Member member) {
		//this.member = member;
		//member.getBoardList().add(this);
	}



