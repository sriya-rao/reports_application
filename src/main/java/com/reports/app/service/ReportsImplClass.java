package com.reports.app.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.reports.app.entity.CitizenPlan;
import com.reports.app.repo.CitizenRepository;
import com.reports.app.request.SearchRequest;
import com.reports.app.util.EmailUtil;
import com.reports.app.util.ExcelGenerator;
import com.reports.app.util.PDFgenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportsImplClass implements ReportService{

	@Autowired
	CitizenRepository repository;
	
	@Autowired
	private ExcelGenerator excel;
	
	@Autowired
	private PDFgenerator pdf;
	
	@Autowired
	private EmailUtil email;
	
	@Override
	public List<String> getPlanNames() {
       
		return repository.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {

		return repository.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		
		CitizenPlan entity=new CitizenPlan();
		if(null!=request.getCitizenPlan() && !"".equals(request.getCitizenPlan())) {
			entity.setCitizenPlan(request.getCitizenPlan());
		}
		
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		if(null!=request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		
		if(null!=request.getStartDate() && !"".equals(request.getStartDate())) {
			String date=request.getStartDate();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(date, format);
			entity.setPlanStartDate(localDate);
		}
		
		if(null!=request.getEndDate() && !"".equals(request.getEndDate())) {
			String date=request.getEndDate();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(date, format);
			entity.setPlanStartDate(localDate);
		}

		return repository.findAll(Example.of(entity));
	}

	@Override
	public Boolean exportExcel(HttpServletResponse response) throws Exception {
		List<CitizenPlan> list=repository.findAll();
		excel.generate(response, list);
		String subject="Test Mail";
		String body="<h2>Test</h2>";
		String to="srr135123@gmail.com";
		File file=new File("plans.xls");
		email.sendEmail(subject, body, to, file);
		file.delete();
		return true;
	}

	@Override
	public Boolean exportPDF(HttpServletResponse response)throws Exception{
		List<CitizenPlan> list=repository.findAll();
		File file=new File("plans.pdf");
		pdf.generatePDF(response, list, file);
		String subject="Test Mail";
		String body="<h2>Test</h2>";
		String to="srr135123@gmail.com";
		email.sendEmail(subject, body, to, file);
		file.delete();
		return true;
	}

}
