package com.myfitness.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="board_seq")
	private Long bseq;
	
	private String title;
	private String writer;
	
	@Column(nullable = false) // null 값 비허용 @nonNull? column
	private String content;		
	
	private String category;	// 카테고리

	@CreationTimestamp
	@Column(name="create_date", updatable = false)
	private Date createDate; 

	
//	@Column(updatable = false, columnDefinition = "number default 0")
//	private Long cnt; // 조회수
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="MEMBER_ID", insertable=false, updatable=false, nullable = false) // nullable=false
//	private Member member;

//	public void setMember(Member member) {
//		this.member = member;
//		member.getBoardList().add(this);
//	}
	
}
