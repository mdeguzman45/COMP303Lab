<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Program Enrollment</title>
</head>
<body>
	<br />
	<div class="container">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div>
					<h4>Program Enrollment Form</h4>
				</div>
				<div class="bg-light mt-4 p-3">
					<form class="row g-3">
						<div class="col-md-4">
							<b>Program Name:</b>
						</div>
						<div class="col-md-8">
							${program.programName}
						</div>
						
						<div class="col-md-4">
							<b>Duration:</b>
						</div>
						<div class="col-md-8">
							${program.duration}
						</div>
						
						<div class="col-md-4">
							<b>Fee:</b>
						</div>
						<div class="col-md-8">
							${program.fee}
						</div>
						
						<div class="col-md-4">
							<b>Credit Card Number:</b>
						</div>
						<div class="col-md-8">
							<input type="text" name="creditcard" class="form-control" />
						</div>
						
						<div class="col-md-4">
							<b>Start Date:</b>
						</div>
						<div class="col-md-8">
							<input type="date" name="startdate" class="form-control" />
						</div>
						
						<div class="col-md-4"></div>
						<div class="col-md-8 gap-4 d-md-flex justify-content-md-end">
							<button type="submit" class="btn btn-primary">Enroll</button>
							<!-- <button type="button" class="btn btn-warning">Cancel</button>  -->
							
							<a href="program" class="btn btn-warning" >Cancel</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>


<!-- 
todo: 
- search date picker if meron
- http post for saving enrollment form
- create confirmation page for enrollment

 -->