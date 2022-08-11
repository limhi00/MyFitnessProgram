package com.myfitness.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private Long id;
	
	private String title;
	private String writer;
	
	@Column(nullable = false) // null 값 비허용
	private String content;			  
	
	@Column(name = "createdate", updatable = false) // DB 컬럼명 CREATE_DATE => CREATEDATE
	private LocalDateTime createDate; // 생성일자

	@Column(updatable = false, columnDefinition = "number default 0")
	private Long cnt; // 조회수
	
//	@ManyToOne
//	@JoinColumn(name="mid", nullable=false, updatable=false)
//	private Member member;
	
}
