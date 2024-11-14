package com.reports.app.service;

import java.util.List;

import com.reports.app.entity.CitizenPlan;
import com.reports.app.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {

	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public Boolean exportExcel(HttpServletResponse response) throws Exception;
	
	public Boolean exportPDF(HttpServletResponse response) throws Exception;
	
	
}
