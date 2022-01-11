function allowAlphaNumericSpace(e) {
  var code = ('charCode' in e) ? e.charCode : e.keyCode;
  if (!(code == 32) && // space
    !(code > 47 && code < 58) && // numeric (0-9)
    !(code > 64 && code < 91) && // upper alpha (A-Z)
    !(code > 96 && code < 123)) { // lower alpha (a-z)
    e.preventDefault();
  }
}

function numericOnly(e) {
  var code = ('charCode' in e) ? e.charCode : e.keyCode;
  if (!(code > 47 && code < 58))// numeric (0-9)
	{ // lower alpha (a-z)
    e.preventDefault();
  }
}

function validateForm() {
	
	var orderForm = document.orderForm;
	var firstName = orderForm.firstName.value;
	var lastName = orderForm.lastName.value;
	var brand = orderForm.brand.value;
	var model = orderForm.model.value;
	var email = orderForm.email.value;
	var areaCode = orderForm.areaCode.value;
	var phoneNumber = orderForm.phoneNumber.value;
	var streetAddress = orderForm.streetAddress.value;
	var city = orderForm.city.value;
	var state = orderForm.state.value;
	var country = orderForm.country.value;
	
	if (firstName == "" || firstName == undefined)
	{
		alert("Please enter your First Name.");
		orderForm.firstName.focus();
		return false;
	}
	
	if (lastName == "" || lastName == undefined)
	{
		alert("Please enter your Last Name.");
		orderForm.lastName.focus();
		return false;
	}
	
	if (email == "" || email == undefined)
	{
		alert("Please enter your Email.");
		orderForm.email.focus();
		return false;
	} else {
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!filter.test(email)) {
			alert('Please provide a valid email address');
			orderForm.email.focus();
			return false;
		}
	}
	
	if (areaCode == "" || areaCode == undefined)
	{
		alert("Please enter your area code.");
		orderForm.areaCode.focus();
		return false;
	}
	
	if (phoneNumber == "" || phoneNumber == undefined)
	{
		alert("Please enter your phone number.");
		orderForm.phoneNumber.focus();
		return false;
	}
	
	if (streetAddress == "" || streetAddress == undefined)
	{
		alert("Please enter your street address.");
		orderForm.streetAddress.focus();
		return false;
	}
	
	if (city == "" || city == undefined)
	{
		alert("Please enter your city.");
		orderForm.city.focus();
		return false;
	}
	
	if (state == "" || state == undefined)
	{
		alert("Please enter your state.");
		orderForm.state.focus();
		return false;
	}
	
	if (country == "")
	{
		alert("Please select your country.");
		orderForm.country.focus();
		return false;
	}
	
	if (brand == "") {
		alert("Please select laptop brand.");
		orderForm.brand.focus();
		return false;
	}
	
	if (model == "" || model == undefined) {
		alert("Please select model.");
		orderForm.model.focus();
		return false;
	}

}