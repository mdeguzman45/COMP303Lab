<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/css/index.css" var="indexCss" />
<spring:url value="/js/validators.js" var="validatorJs" />
<link href="${indexCss}" rel="stylesheet" />
<meta charset="ISO-8859-1">
<script language="Javascript" src="${validatorJs}"></script>
<script language="Javascript">

	function loadModel(brand) {
		var list;
		var listValue;
		var selectModel = document.orderForm.model;
		
		// clear options of model first
		while (selectModel.length > 0) {
			selectModel.remove(0);
		}

		if (brand == "Acer") {
			list = new Array("Please Select", "Acer Nitro 5 17.3 inch", "Acer Predator Triton 300 SE 14 inch", "Acer Aspire 5 15.6 inch");
			listValue = new Array("", "acer_nitro_5_17_3", "acer_predator_triton_14", "acer_aspire_5_15");

		} else if (brand == "Asus") {
			list = new Array("Please Select", "ASUS Vivobook 15.6 inch", "ASUS ROG Strix G15 15.6 inch", "ASUS TUF Dash 15 15.6 inch");
			listValue = new Array("", "asus_vivo_15", "asus_rog_strix_g15_15", "asus_tuf_dash_15");
		} else if (brand == "Dell") {
			list = new Array("Please Select", "Dell Inspiron 15.6 inch", "Dell Inspiron 5000 14 inch Touchscreen 2-in-1", "Dell XPS 15 9510 15 inch");
			listValue = new Array("", "dell_inspiron_15", "dell_inspiron_14", "dell_xps_15");
		} else if (brand == "HP") {
			list = new Array("Please Select", "HP ENVY 13.3 inch - Natural Silver", "HP OMEN 15.6 inch Gaming Laptop", "HP Pavilion 15.6 inch Gaming Laptop");
			listValue = new Array("", "hp_envy_13_silver", "hp_omen_gaming_15", "hp_pavilion_gaming_15");
		} else if (brand == "Macbook") {
			list = new Array("Please Select", "Apple MacBook Air 13.3 inch with Touch ID", "Apple MacBook Pro 13.3 inch with Touch Bar", "Apple MacBook Air 11 inch");
			listValue = new Array("", "macbook_air_13", "macbook_pro_13", "macbook_air_11");
		} else {
			list = new Array();
			listValue = new Array();
			selectModel.disabled = true;
			
			return;
		}
		
		// populate the model dropdown
		for (var i = 0; i < list.length; i++) { 
			selectModel.options[i] = new Option(list[i],listValue[i],0,0);
		}
		
		selectModel.disabled = false;
		
	}
</script>
<title>Laptop Order Form</title>
</head>
<body>
	<h2>LAPTOP ORDER FORM</h2>

	<form:form action="processOrder" method="POST" modelAttribute="order" name="orderForm" onsubmit="return validateForm()">
		<div class="section-heading">Full Name</div>
		<div>
			<div class="form-section-row">
				<div class="form-section-item-row">
					<div>
						<form:input class="name-input" type="text" name="firstName" path="firstName" onkeypress="allowAlphaNumericSpace(event)" />
					</div>
					<div>
						<label>First Name</label>
					</div>
				</div>
				<div class="form-section-item-row">
					<div>
						<form:input class="name-input" type="text" name="middleName" path="middleName" 
							width="250px" onkeypress="allowAlphaNumericSpace(event)" />
					</div>
					<div>
						<label>Middle Name</label>
					</div>
				</div>
				<div class="form-section-item-row">
					<div>
						<form:input class="name-input" type="text" name="lastName" path="lastName" 
							width="250px" onkeypress="allowAlphaNumericSpace(event)" />
					</div>
					<div>
						<label>Last Name</label>
					</div>
				</div>
			</div>
		</div>

		<div class="section-divider"></div>

		<div class="section-heading">E-mail</div>
		<div class="form-section-row">
			<div class="form-section-item-row">
				<div>
					<form:input class="email-input" type="text" path="email" name="email"
						placeholder="ex: myname@example.com" style="width: 300px;" />
				</div>
				<div>
					<label>example@example.com</label>
				</div>
			</div>
		</div>

		<div class="section-divider"></div>

		<div class="section-heading">Contact Number</div>
		<div class="form-section-row">
			<div class="form-section-item-row">
				<div>
					<form:input type="text" path="areaCode" style="width: 100px;" onkeypress="numericOnly(event)" name="areaCode" /> -
				</div>
				<div>
					<label>Area Code </label>
				</div>
			</div>
			<div class="form-section-item-row">
				<div>
					<form:input type="text" path="phoneNumber" style="width: 300px;" onkeypress="numericOnly(event)" name="phoneNumber" />
				</div>
				<div>
					<label>Phone Number</label>
				</div>
			</div>
		</div>

		<div class="section-divider"></div>

		<div class="section-heading">Billing Address</div>

		<div class="form-section-column">
			<div class="form-section-item-column">
				<div>
					<form:input type="text" path="streetAddress" style="width: 300px;" onkeypress="allowAlphaNumericSpace(event)" name="streetAddress" />
				</div>
				<div>
					<label>Street Address </label>
				</div>
			</div>
			<div class="form-section-item-column">
				<div>
					<form:input type="text" path="streetAddress2" style="width: 300px;" onkeypress="allowAlphaNumericSpace(event)" />
				</div>
				<div>
					<label>Street Address Line 2</label>
				</div>
			</div>
			<div class="form-section-row">
				<div class="form-section-item-row">
					<div>
						<form:input type="text" path="city" style="width: 148px;" onkeypress="allowAlphaNumericSpace(event)" name="city" />
					</div>
					<div>
						<label>City </label>
					</div>
				</div>
				<div class="form-section-item-row">
					<div>
						<form:input type="text" path="state" style="width: 148px;" onkeypress="allowAlphaNumericSpace(event)" name="state" />
					</div>
					<div>
						<label>State / Province </label>
					</div>
				</div>
			</div>


			<div class="form-section-row">
				<div class="form-section-item-row">
					<div>
						<form:input type="text" path="postCode" style="width: 155px;" onkeypress="allowAlphaNumericSpace(event)" />
					</div>
					<div>
						<label>Postal / Zip Code </label>
					</div>
				</div>
				<div class="form-section-item-row">
					<div>
						<form:select path="country" style="width: 148px; height: 25px;" name="country" >
						<form:option value="">Please Select</form:option>
						<form:options items = "${countryList}" />
						</form:select>
					</div>
					<div>
						<label>Country </label>
					</div>
				</div>
			</div>


		</div>

		<div class="section-divider"></div>

		<div class="section-heading">Product Details</div>
		<div class="form-section-column">
			<div class="form-section-row">
				<div class="form-section-item-row">
					<div class="product-details">
						<label>Product # </label>
					</div>
				</div>
				<div class="form-section-item-row">
					<div>
						<form:input type="text" path="productNumber" style="width: 150px;" onkeypress="allowAlphaNumericSpace(event)" />
					</div>
				</div>
			</div>

			<div class="form-section-row">
				<div class="form-section-item-row">
					<div class="product-details">
						<label>Brand </label>
					</div>
				</div>
				<div class="form-section-item-row">
					<div>
						<form:select path="brand" style="width: 152px; height: 25px;" onchange="loadModel(this.value)" name="brand">
							<form:option value="">Please Select</form:option>
							<form:options items = "${brandList}" />
						</form:select>
					</div>
				</div>
			</div>

			<div class="form-section-row">
				<div class="form-section-item-row">
					<div class="product-details">
						<label>Model </label>
					</div>
				</div>
				<div class="form-section-item-row">
					<div>
						<form:select path="model" style="width: 152px; height: 25px;" name="model" disabled="true">
						</form:select>
					</div>
				</div>
			</div>

			<div class="form-section-row">
				<div class="form-section-item-row">
					<div class="product-details">
						<label>Quantity </label>
					</div>
				</div>
				<div class="form-section-item-row">
					<div>
						<form:input type="number" path="quantity" min="1" max="100" style="width: 150px;" />
					</div>
				</div>
			</div>
		</div>

		<div class="section-divider"></div>
		
		<button type="submit" class="submit">Submit Order</button>
		<!-- <button type="button" class="submit" onclick="validateForm()">Submit Order</button> -->
	</form:form>
</body>
</html>
