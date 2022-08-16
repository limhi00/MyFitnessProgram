package com.myfitness.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Member {
	
	@Id
	@JoinColumn(name = "MEMBER_ID")
	private String mid;           // member ID
	private String name;          // member 이름
	private String password;

	@CreationTimestamp
	@Column(name="create_date", updatable = false)
	private LocalDateTime createDate; 
	
//	private String role;

//	@Enumerated(EnumType.STRING)
//	private Role role;
	
//	private boolean enabled;
	
//	@Column(name = "createdate", insertable = false, updatable = false) // DB 컬럼명 CREATE_DATE => CREATEDATE
//	private LocalDateTime createDate; // 생성일자
	
//	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//	private List<Board> boardList = new ArrayList<Board>();
	
	/*
	 * FetchType은 JPA가 하나의 Entity 를 조회할 때, 연관관계에 있는 객체들을 어떻게 가져올 것인지 정하는 설정값이다.
	 * Eager와 Lazy 두가지로 나뉜다.
	 * @ManyToOne은 FetchType.EAGER, @OneToMany는 Fetch.LAZY가 기본 설정이다.
	 */

	
}
