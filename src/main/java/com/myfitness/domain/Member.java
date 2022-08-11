package com.myfitness.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString //(exclude="boardList")
@Entity
public class Member {

	@Id
	private String mid;           // member ID
	private String name;          // member 이름
	private String password;
	private String zipNum;	      // 우편번호
	private String address;       // 주소
	private String addressDetail; // 상세주소
//	private String email;
	private String phone;
	private String gender;        // 성별
	private String ptyn;          // PT 여부
	private String cTrainer;      // PT 여부가 'y'인 경우 트레이너 이름으로 선택, 직접 작성
	
//	@Column(updatable = false)
//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createDate; // 생성일자
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private boolean enabled;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Board> boardList = new ArrayList<Board>();
	
}
