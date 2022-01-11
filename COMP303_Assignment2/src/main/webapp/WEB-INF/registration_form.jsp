<%-- <%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%> --%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Customer Registration</title>
</head>
<body>
	<br />
	<div class="container" style="margin-bottom: 100px;">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div>
					<h3>Customer Registration - Sign up</h3>
				</div>
				<div class="bg-light mt-4 p-4">

					<form:form action="/process_register" method="POST" class="row g-3"
						modelAttribute="customer">
						<div class="col-md-6">
							<label for="userName">User Name</label>
							<form:input type="text" name="userName" class="form-control"
								placeholder="myuser" path="userName" required="true" />
						</div>

						<div class="col-md-6">
							<label for="password">Password</label>
							<form:input type="password" name="password" class="form-control"
								path="password" required="true" minlength="6" maxlength="16" />
						</div>

						<div class="col-md-6">
							<label for="firstName">First Name</label>
							<form:input type="text" name="firstName" class="form-control"
								path="firstName" required="true" minlength="3" />
						</div>

						<div class="col-md-6">
							<label for="lastName">Last Name</label>
							<form:input type="text" name="lastName" class="form-control"
								path="lastName" required="true" minlength="3" />
						</div>

						<div class="col-md-12">
							<label for="address">Address</label>
							<form:input type="text" name="address" class="form-control"
								path="address" required="true" />
						</div>

						<div class="col-md-6">
							<label for="city">City</label>
							<form:input type="text" name="city" class="form-control"
								path="city" required="true" />
						</div>

						<div class="col-md-6">
							<label for="postalCode">Postal Code</label>
							<form:input type="text" name="postalCode" class="form-control"
								path="postalCode" required="true" />
						</div>

						<div class="col-md-6"></div>
						<div class="col-md-6 gap-4 d-md-flex justify-content-md-end">
							<button type="submit" class="btn btn-primary">Register</button>
							<button type="button" class="btn btn-warning">Clear</button>
						</div>

					</form:form>

				</div>
			</div>

		</div>
	</div>
</body>
</html>

<%-- <%@ include file="common/footer.jspf"%> --%>