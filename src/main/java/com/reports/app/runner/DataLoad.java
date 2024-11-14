package com.reports.app.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.reports.app.entity.CitizenPlan;
import com.reports.app.repo.CitizenRepository;

@Component
public class DataLoad implements ApplicationRunner{
	
	@Autowired
	CitizenRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		repository.deleteAll();
		
		CitizenPlan c1=new CitizenPlan();
		c1.setCitizenName("Sri");
		c1.setGender("Female");
		c1.setCitizenPlan("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmount(5000.0);
		
		
		CitizenPlan c2=new CitizenPlan();
		c2.setCitizenName("Rao");
		c2.setGender("Male");
		c2.setCitizenPlan("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Rental Income");
		
		CitizenPlan c3=new CitizenPlan();
		c3.setCitizenName("John");
		c3.setGender("Male");
		c3.setCitizenPlan("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenefitAmount(5000.0);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTermReason("Employed");
		
		
		
		CitizenPlan c4=new CitizenPlan();
		c4.setCitizenName("shashi");
		c4.setGender("Female");
		c4.setCitizenPlan("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmount(5000.0);
		
		
		CitizenPlan c5=new CitizenPlan();
		c5.setCitizenName("Anu");
		c5.setGender("Male");
		c5.setCitizenPlan("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Property Income");
		
		CitizenPlan c6=new CitizenPlan();
		c6.setCitizenName("Raj");
		c6.setGender("Male");
		c6.setCitizenPlan("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenefitAmount(5000.0);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTermReason("Employed");


	  List<CitizenPlan>  list=	Arrays.asList(c1,c2,c3,c4,c5,c6);
	  repository.saveAll(list);
		
		
	}

	
}
