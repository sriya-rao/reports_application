package com.reports.app.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.reports.app.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PDFgenerator {

	
	public void generatePDF(HttpServletResponse response, List<CitizenPlan> list,File file) throws Exception {
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		
		Paragraph p=new Paragraph("Citizen Plans");
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p);
		p.setSpacingAfter(10.0f);
		PdfPTable table=new PdfPTable(6);
		table.addCell("Id");
		table.addCell("CitizenName");
		table.addCell("Plan");
		table.addCell("Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		
		for (CitizenPlan plan : list) {
			table.addCell(String.valueOf(plan.getId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getCitizenPlan());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate()+"");
			table.addCell(plan.getPlanEndDate()+"");
		}
		
		document.add(table);
        document.close();
	}
}
