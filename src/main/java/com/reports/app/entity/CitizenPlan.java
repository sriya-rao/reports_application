package com.reports.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Citizen_Plan_Info")
public class CitizenPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String citizenName;
	
	private String gender;
	
	private String citizenPlan;
	
	private String planStatus;

	private LocalDate planStartDate;

	private LocalDate planEndDate;
	
	private Double benefitAmount;
	
	private String denialReason;
	
	private LocalDate terminatedDate;
	
	private String termReason;

}
