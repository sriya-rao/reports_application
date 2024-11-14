package com.reports.app.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.reports.app.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator{

		
	public void generate(HttpServletResponse response, List<CitizenPlan> list) throws Exception {
		
		
		Workbook workbook=new HSSFWorkbook();
		
		Sheet sheet=workbook.createSheet("plans_info");
		
		Row header=sheet.createRow(0);
		header.createCell(0).setCellValue("Id");
		header.createCell(1).setCellValue("CitizenName");
		header.createCell(2).setCellValue("CitizenPlan");
		header.createCell(3).setCellValue("PlanStatus");
		header.createCell(4).setCellValue("StartDate");
		header.createCell(5).setCellValue("EndDate");
		header.createCell(6).setCellValue("BenefitAmount");
        
		int index=1;
		
		for (CitizenPlan plan : list) {
			Row data=sheet.createRow(index);
			data.createCell(0).setCellValue(plan.getId());
			data.createCell(1).setCellValue(plan.getCitizenName());
			data.createCell(2).setCellValue(plan.getCitizenPlan());
			data.createCell(3).setCellValue(plan.getPlanStatus());
			if(null!=plan.getPlanStartDate())
			data.createCell(4).setCellValue(plan.getPlanStartDate()+"");
			else {
				data.createCell(4).setCellValue("NA");
			}
			
			if(null!=plan.getPlanEndDate())
			data.createCell(5).setCellValue(plan.getPlanEndDate()+"");
			else {
				data.createCell(5).setCellValue("NA");
			}
			if(null!=plan.getBenefitAmount())
			data.createCell(6).setCellValue(plan.getBenefitAmount());
             else {
     			data.createCell(6).setCellValue("NA");
			}
			index++;
		}

		FileOutputStream file=new FileOutputStream(new File("plans.xls"));
		workbook.write(file);
		file.close();
		
		
     ServletOutputStream fos=response.getOutputStream();
		workbook.write(fos);
		workbook.close();
		
	}
	
}
