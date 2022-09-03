package com.myfitness.dto;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.myfitness.domain.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@ToString
public class MemberJoinDTO { 
	
	@Size(min = 3, max = 25)
	@NotBlank(message = "ID는 필수 입력 항목입니다.")
	private String username;
	
	@Size(min = 2, max = 10, message = "최소 2글자 이상 입력해 주세요.")
	@NotBlank(message = "이름은 필수 입력 항목입니다.")
	private String name;
	
	@NotBlank(message = "전화번호는 필수 입력 항목입니다.")
	private String phone;
	
	@Size(min = 3, max = 10)
	@NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
	private String password1;
	
	@Size(min = 3, max = 10)
	@NotBlank(message = "비밀번호 확인을 해주세요.")
	private String password2;
	
	@NotBlank(message = "이메일은 필수 입력 항목입니다!")
	@Email(message = "이메일 형식에 맞게 작성해 주세요.")
	private String email;
	
	@NotNull(message = "가입 유형은 필수 입력 항목입니다.")
	private Role role;

}
