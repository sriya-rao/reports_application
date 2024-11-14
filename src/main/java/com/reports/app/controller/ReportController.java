package com.reports.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.reports.app.entity.CitizenPlan;
import com.reports.app.request.SearchRequest;
import com.reports.app.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;
	
	public void addDynamicComponents(Model model) {
		model.addAttribute("plans", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatus());
	}
	
	@GetMapping("/index")
	public String indexPage(Model model) {
		model.addAttribute("search", new SearchRequest());
      	addDynamicComponents(model);
		return "index";
	}
	
	
	@PostMapping("/search")
	public String search(SearchRequest request,Model model) {
		System.out.println(request);
		model.addAttribute("search", request);
		List<CitizenPlan> list=service.search(request);
		model.addAttribute("plan", list);
		addDynamicComponents(model);
		return "index";
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response,Model model) throws Exception {
		response.setContentType("application/octet-stream");
		response.setHeader("content-disposition", "attachment;filename=plans.xls");
		Boolean isSent=service.exportExcel(response);
		if(isSent) {
			model.addAttribute("success", "Mail Sent Success");
		}
	}
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response,Model model) throws Exception {
		response.setContentType("application/pdf");
		response.setHeader("content-disposition", "attachment;filename=plans.pdf");
		Boolean isSent=service.exportPDF(response);
		if(isSent) {
			model.addAttribute("success", "Mail Sent Success");
		}

	}
	
}
