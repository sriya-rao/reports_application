<%@page import="com.reports.app.request.SearchRequest"%>
<%@page import="com.reports.app.entity.CitizenPlan"%>
<%@page import="java.util.List"%>
<%@page import="com.reports.app.service.ReportsImplClass"%>
<%@page import="com.reports.app.service.ReportService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html >
<html xmlns:th="https://www.thymeleaf.org/">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-4">
<form:form method="POST" action="search" modelAttribute="search">
             <table>
                <tr>
                    <td><form:label path="citizenPlan">Plan Name</form:label></td>
                    <td><form:select path="citizenPlan" class="form-control">
                    
                    <form:option value="">-Select-</form:option>
                    <form:options items="${plans}"></form:options>
                    </form:select>
                    </td>
                    
                    
                     <td><form:label path="planStatus">Plan Status</form:label></td>
                    <td><form:select path="planStatus" class="form-control">
                    <form:option value="">-Select-</form:option>
                    <form:options items="${status}"></form:options>
                    </form:select>
                    </td>
                    
                     <td><form:label path="gender">Gender</form:label></td>
                    <td><form:select path="gender" class="form-control">
                                        <form:option value="">-Select-</form:option>
                    
                    <form:option value="Male">Male</form:option>
                    <form:option value="Female">Female</form:option>
                    </form:select>
                    </td>
                </tr>
                
                
                <tr>
                    <td><form:label path="startDate">Start Date</form:label></td>
                    <td><form:input path="startDate" type="date" class="form-control"/></td>
                    
                    
                    <td><form:label path="endDate">  End Date</form:label></td>
                    <td><form:input path="endDate" type="date" class="form-control"/></td>
                    
                   <td><input type="submit" class="btn btn-primary" value="Search"/>
                   <a href="/index" class="btn btn-secondary">Reset</a>
                   </td>

                </tr>
                
            </table>
        </form:form>
<hr>

Export : <a href="/excel" class="btn btn-warning">Excel</a>
<a href="/pdf" class="btn btn-warning">PDF</a>
<div class="text-center">
<h5>${success}</h5>
</div>
<br>
<br>

<table class="table table-striped table-bordered table-hover">
<thead class="thead-dark">
<tr>
<th>Id</th>
<th>Name</th>
<th>Plan</th>
<th>Status</th>
<th>Gender</th>
<th>Start Date</th>
<th>End Date</th>
</tr>
</thead>

<tbody>

 <c:forEach items="${plan}" var="plan" >
<tr>
<td>${plan.id}</td>
<td>${plan.citizenName}</td>
<td>${plan.citizenPlan}</td>
<td>${plan.planStatus}</td>
<td>${plan.gender}</td>
<td>${plan.planStartDate}</td>
<td>${plan.planEndDate}</td>
</tr>
</c:forEach> 

</tbody>

</table>
<c:if test="${empty plan}">
<div class="text-center">
<h4>No Records found</h4>
</div>
</c:if>





</div>

</body>
</html>