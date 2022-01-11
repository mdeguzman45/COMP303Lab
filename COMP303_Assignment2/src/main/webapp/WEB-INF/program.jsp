<%--
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
 --%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Available Programs</title>
</head>
<body>
	<br />
	<div class="container">
		<p>
			Welcome <b> ${customerName} </b>
		</p>

		<div class="col-md-8 offset-md-2">
			<h4>Available Programs</h4>
			<table class="table table-bordered">
				<tr>
					<th>Program Name</th>
					<th>Duration</th>
					<th>Fee</th>
					<th>Action</th>
				</tr>

				<c:forEach var="program" items="${programs}">
					<tr>
						<td>${program.programName}</td>
						<td>${program.duration}</td>
						<td>$${program.fee}</td>
						<td><a href="registerprogram?programCode=${program.programcode}"> Enroll </a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
		<div class="gap-4">
			<a href="updateprofile" class="btn btn-primary"> Update Profile </a>
			<a href="logout" class="btn btn-warning"> Logout </a>
		</div>
	</div>
</body>
</html>

<%-- <%@ include file="common/footer.jspf" %> --%>

