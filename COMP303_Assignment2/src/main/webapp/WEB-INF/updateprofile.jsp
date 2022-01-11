<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Customer Update Details</title>
</head>
<body>
	<br />
	<div class="container" style="margin-bottom: 100px;">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div>
					<h3>Customer Update Details</h3>
				</div>
				<div class="bg-light mt-4 p-4">

					<form:form action="/processupdateuser" method="POST" class="row g-3"
						modelAttribute="customer">
						<!--<div class="col-md-6">
							<label for="userName">User Name</label>
							<form:input type="text" name="userName" class="form-control"
								placeholder="myuser" path="userName" required="true" />
						</div>

						<div class="col-md-6">
							<label for="password">Password</label>
							<form:input type="password" name="password" class="form-control"
								path="password" required="true" minlength="6" maxlength="16" />
						</div>-->

						<div class="col-md-6">
							<label for="firstName">First Name</label>
							<form:input type="text" name="firstName" class="form-control"
								path="firstName" required="true" minlength="3" value="${currentCustomer.firstName}" />
						</div>

						<div class="col-md-6">
							<label for="lastName">Last Name</label>
							<form:input type="text" name="lastName" class="form-control"
								path="lastName" required="true" minlength="3" value="${currentCustomer.lastName}" />
						</div>

						<div class="col-md-12">
							<label for="address">Address</label>
							<form:input type="text" name="address" class="form-control"
								path="address" required="true" value="${currentCustomer.address}" />
						</div>

						<div class="col-md-6">
							<label for="city">City</label>
							<form:input type="text" name="city" class="form-control"
								path="city" required="true" value="${currentCustomer.city}" />
						</div>

						<div class="col-md-6">
							<label for="postalCode">Postal Code</label>
							<form:input type="text" name="postalCode" class="form-control"
								path="postalCode" required="true" value="${currentCustomer.postalCode}" />
						</div>

						<div class="col-md-6"></div>
						<div class="col-md-6 gap-4 d-md-flex justify-content-md-end">
							<button type="submit" class="btn btn-primary"> Update </button>
							<a href="program" class="btn btn-warning"> Cancel </a>
						</div>

					</form:form>

				</div>
			</div>

		</div>
	</div>
</body>
</html>