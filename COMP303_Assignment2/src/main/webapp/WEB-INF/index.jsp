<%-- <%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %> --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/login" var="loginUrl" />
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Assignment 2</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="login-form bg-light mt-4 p-4">
					<form action="${loginUrl}" method="POST" class="row g-3">
						<c:if test="${param.error != null}">
							<div class="alert alert-danger">Invalid username and/or password.</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">You have been logged out.</div>
						</c:if>
						<h4>Welcome Back</h4>
						<div class="col-12">
							<label>Username</label> <input type="text" name="username"
								id="username" class="form-control" placeholder="Username">
						</div>
						<div class="col-12">
							<label>Password</label> <input type="password" name="password"
								id="password" class="form-control" placeholder="Password">
						</div>
						<!-- <div class="col-12">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" id="rememberMe">
								<label class="form-check-label" for="rememberMe">
									Remember me</label>
							</div>
						</div> -->
						<div class="col-12">
							<button type="submit" class="btn btn-dark float-end">Login</button>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
					<hr class="mt-4">
					<div class="col-12">
						<p class="text-center mb-0">
							Have no account yet? <a href="/register">Signup</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<%-- <%@ include file="common/footer.jspf" %> --%>