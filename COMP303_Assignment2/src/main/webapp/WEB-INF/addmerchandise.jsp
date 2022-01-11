<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Add Merchandise</title>
</head>
<body>
	<br />
	<div class="container">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<h4>Add Merchandise Details</h4>
				<!-- <h4>Update Merchandise Details</h4> -->
				<div class="mt-4 p-4">
					<form action="" method="" class="row g-3">
						<div class="mb-3 row">
							<label for="productname" class="col-sm-4 col-form-label">Merchandise Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="productname">
							</div>
						</div>
						
						<div class="mb-3 row">
							<label for="productprice" class="col-sm-4 col-form-label">Merchandise Price</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="productprice">
							</div>
						</div>
						
						<div class="mb-3 row">
							<label for="volume" class="col-sm-4 col-form-label">Merchandise Volume</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="volume">
							</div>
						</div>
						
						<div class="mb-3 row">
							<label for="allergens" class="col-sm-4 col-form-label">Allergens</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="allergens">
							</div>
						</div>
						
						<div class="col-sm-12 gap-2 d-md-flex justify-content-md-end">
							<button type="button" style="width: 150px;">Add Merchandise</button>
							<!-- <button type="button" style="width: 225px;">Update Merchandise</button>  -->
							<button type="button" style="width: 150px;">Cancel</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>