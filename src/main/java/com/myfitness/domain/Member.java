package com.myfitness.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString//(exclude = "boardList")
@Entity
public class Member {
	
	@Id
	//@JoinColumn(name = "MEMBER_ID")
	private String mid;
	
	@Column(unique = true)
	private String name;
	
	//@Column(length = 20) 50~60
	private String password;
	
	@Column(length = 50, unique = true)
	private String email;

	@CreationTimestamp
	@Column(name="create_date", updatable = false)
	private LocalDateTime createDate; 
	
	@Enumerated(EnumType.STRING)
	private Role role;

}
