package com.reports.app.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchRequest {

	
	private String citizenPlan;
	
	private String planStatus;
	
	private String gender;
	
	private String startDate;
	
	private String endDate;
}
