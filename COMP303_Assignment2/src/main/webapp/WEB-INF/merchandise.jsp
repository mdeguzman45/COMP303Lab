<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Merchandise Admin</title>
</head>
<body>
	<br />
	<div class="container">
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<h4>Merchandise List</h4>
				<div class="mt-2 p-4">
					<h5><button type="button" style="width: 200px;">Add Merchandise</button></h5>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col" style="width: 35%;">Merchandise Name</th>
								<th scope="col">Price</th>
								<th scope="col">Volume</th>
								<th scope="col">Allergens</th>
								<!-- <th scope="col">Last</th> -->
								<th scope="col" style="width: 35%;">Action</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>Merchandise 1</td>
								<td>$xx.xx</td>
								<td>150 Liters</td>
								<td>Contains Soy</td>
								<td>
									<button type="button" style="width: 100px;">Update</button>
									<button type="button" style="width: 100px;">Remove</button>
								</td>
							</tr>
							<tr>
								<th scope="row">2</th>
								<td>Merchandise 2</td>
								<td>$xx.xx</td>
								<td>50 Liters</td>
								<td>Organic</td>
								<td>
									<button type="button" style="width: 100px;">Update</button>
									<button type="button" style="width: 100px;">Remove</button>
								</td>
							</tr>
							<tr>
								<th scope="row">3</th>
								<td>Merchandise 3</td>
								<td>$xx.xx</td>
								<td>20 Liters</td>
								<td>Non-Organic</td>
								<td>
									<button type="button" style="width: 100px;">Update</button>
									<button type="button" style="width: 100px;">Remove</button>
								</td>
							</tr>
							<tr>
								<th scope="row">4</th>
								<td>Merchandise 4</td>
								<td>$xx.xx</td>
								<td>100 Kilograms</td>
								<td>Organic</td>
								<td>
									<button type="button" style="width: 100px;">Update</button>
									<button type="button" style="width: 100px;">Remove</button>
								</td>
							</tr>
							<tr>
								<th scope="row">5</th>
								<td>Merchandise 5</td>
								<td>$xx.xx</td>
								<td>325 Kilograms</td>
								<td>Non-Organic</td>
								<td>
									<button type="button" style="width: 100px;">Update</button>
									<button type="button" style="width: 100px;">Remove</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>