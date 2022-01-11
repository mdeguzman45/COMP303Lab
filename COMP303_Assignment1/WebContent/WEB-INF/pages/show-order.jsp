<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/css/show-order.css" var="showOrderCss" />
<link href="${showOrderCss}" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome ${customerName}</h3>
	<h4>Your Order details are as follows:</h4>

	<ul>
		<li>
			<div class="customer-info-section">
				<div class="customer-info-section-header">Email Address:</div>
				<div class="customer-info-section-item"><a href>${email}</a></div>
			</div>

		</li>
		<li>
			<div class="customer-info-section">
				<div class="customer-info-section-header">Phone Number:</div>
				<div class="customer-info-section-item">${phoneNumber}</div>
			</div>

		</li>
		<li>
			<div class="customer-info-section">
				<div class="customer-info-section-header">Address:</div>
				<div class="customer-info-section-item">${address}</div>
			</div>

		</li>
	</ul>

	<h4>Product Details:</h4>
	<div class="product-details">
		<div class="product-details-section">
			<div class="product-details-section-item bold">Brand:</div>
			<div class="product-details-section-item bold">${brand}</div>
		</div>

		<div class="product-details-section">
			<div class="product-details-section-item bold">Model:</div>
			<div class="product-details-section-item-model">${model}</div>
		</div>

		<div class="product-details-section">
			<div class="product-details-section-item bold">Price:</div>
			<div class="product-details-section-item">CAD ${modelPrice}</div>
		</div>

		<div class="product-details-section">
			<div class="product-details-section-item bold">Quantity:</div>
			<div class="product-details-section-item">${quantity}</div>
		</div>

		<div class="section-divider"></div>
		<div class="product-details-section">
			<div style="width: 120px; color: #1e286a; font-weight: bold;">Total</div>
			<div class="product-details-section-item">CAD ${totalPrice}</div>
		</div>
	</div>
</body>
</html>