package com.myfitness.domain;

import lombok.Getter;

/*
 *  Security 권한 지정을 위한 Enum 클래스 
 */

@Getter
public enum Role {
	
	ROLE_MEMBER("회원"), ROLE_TRAINER("트레이너"), ROLE_ADMIN("관리자");
	
    private String value;

    Role(String value) {
        this.value = value;
    }
}