package com.reports.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reports.app.entity.CitizenPlan;

@Repository
public interface CitizenRepository extends JpaRepository<CitizenPlan, Integer>{

	@Query("SELECT distinct(citizenPlan) from CitizenPlan")
	public List<String> getPlanNames();
	
	
	@Query("SELECT distinct(planStatus) from CitizenPlan")
	public List<String> getPlanStatus();

	
}
