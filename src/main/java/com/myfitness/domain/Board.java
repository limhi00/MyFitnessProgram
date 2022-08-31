package com.myfitness.domain;

import java.util.ArrayList;
//1
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private Long bseq;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String writer;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", updatable=false, nullable = false)
	private Member member;
	
	@Column(nullable = false, length = 1000)
	private String content;		
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;	// 카테고리

	@CreationTimestamp
	@Column(name="create_date", updatable = false)
	private Date createDate = new Date();
	
	@Column(nullable = false)
	private String boardPwd;
	
	private String filename;
	private String filepath;
	
	public void setCategory(Category category) {
		this.category = category;
		category.getBoardList().add(this);
	}

	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
	
}
