package com.myfitness.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Member {
	
	//@JoinColumn(name = "MEMBER_ID")
	
	@Id
	@Column(length = 10)
	private String username;
	
	@Column(nullable = false, length = 30)
	private String name;	
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, unique = true, length = 50)
	private String email;
	
	@Column(nullable = false, unique = true, length = 50)
	private String phone;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createDate; 
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<Board> boardList = new ArrayList<Board>();

}
