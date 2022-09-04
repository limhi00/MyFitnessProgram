package com.myfitness.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservationListDto {
	private String title;
	private String start;
	private String url;
	private String color;
	private String textColor;
	private String rendering;
	private Boolean allDay;
}
