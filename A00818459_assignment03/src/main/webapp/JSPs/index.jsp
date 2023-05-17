<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ page import="ca.bcit.comp4656.employee.types.Employee" %>
<%@ page errorPage="/JSPs/ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/style.css" type="text/css" rel="stylesheet" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<title>Employee Admin Tool</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-8 col-sm-8 col-md-9 col-lg-9">
				<h3>Employees List</h3>
				
				<display:table class="table" name="requestScope.employees" id="employees"
								sort="list" pagesize="5" requestURI="" excludedParams="*">
					<display:setProperty name="paging.banner.placement" value="bottom" />
					<display:column property="id" title="ID" sortable="true"/>
					<display:column property="firstName" title="First Name" sortable="true"/>
					<display:column property="lastName" title="Last Name" sortable="true"/>
					<display:column property="dob" title="DOB" sortable="true"/>
				</display:table>
				
			</div>
			<div class="col-4 col-sm-4 col-md-3 col-lg-3">
				<c:if test='${requestScope.role}'>
					<div class="row py-2">
						<jsp:include flush="true" page="/JSPs/admin/AddEmployee.jsp"/>
					</div>
				</c:if>
				<div class="row py-2">
					<jsp:include flush="true" page="/JSPs/FindEmployee.jsp"/>
				</div>
				<c:if test='${requestScope.role}'>
					<div class="row py-2">
						<jsp:include flush="true" page="/JSPs/admin/RemoveEmployee.jsp"/>
					</div>
				</c:if>
				<div class="row py-2">
					<jsp:include flush="true" page="/JSPs/Signout.jsp"/>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
