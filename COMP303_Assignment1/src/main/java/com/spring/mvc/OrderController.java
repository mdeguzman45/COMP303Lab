package com.spring.mvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
	@RequestMapping("/") 
	public ModelAndView showIndexForm(@ModelAttribute("order") Order order) {
		ModelAndView mview = new ModelAndView("index");

		return mview;
	}

//	@RequestMapping("/welcome")
//	public ModelAndView showTempDisplay(
//			@RequestParam(value = "name", required = false, defaultValue = "Hi") String name) {
//		System.out.println("Working");
//
//		String getName = "Get " + name;
//		ModelAndView mview = new ModelAndView("show-order");
//		mview.addObject("empMessage", message);
//		mview.addObject("empName", getName);
//		return mview;
//	}

	@RequestMapping(value = "/processOrder", method = RequestMethod.POST)
	public ModelAndView processOrder(@ModelAttribute Order order) {
		// process order 
		System.out.println("first name: " + order.getFirstName());
		System.out.println("middle name: " + order.getMiddleName());
		System.out.println("last name: " + order.getLastName());
		
		System.out.println("email: " + order.getEmail());
		System.out.println("area code: " + order.getAreaCode());
		System.out.println("phone number: " + order.getPhoneNumber());
		
		System.out.println("street address: " + order.getStreetAddress());
		System.out.println("street address 2: " + order.getStreetAddress2());
		System.out.println("city: " + order.getCity());
		
		System.out.println("state: " + order.getState());
		System.out.println("postal code: " + order.getPostCode());
		System.out.println("country: " + order.getCountry());
		
		System.out.println("product number: " + order.getProductNumber());
		System.out.println("brand: " + order.getBrand());
		System.out.println("model: " + order.getModel());
		
		System.out.println("quantity: " + order.getQuantity());

		ModelAndView mview = new ModelAndView("show-order");	
		mview.addObject("customerName", order.getFirstName());
		
		String brand = order.getBrand();
		String model = order.getModel();
		
		double modelPrice = getModelPrice(brand, model);
		double totalPrice = order.getQuantity() * modelPrice;
		String modelLabel = getModelLabel(brand, model);
		
		System.out.println("model price: " + modelPrice);
		System.out.println("total price: " + totalPrice);
		
		mview.addObject("brand", brand);
		mview.addObject("model", modelLabel);
		mview.addObject("modelPrice", modelPrice);
		mview.addObject("quantity", order.getQuantity());
		mview.addObject("totalPrice", totalPrice);
		
		String phoneNumber = order.getAreaCode() + " - " + order.getPhoneNumber();
		String address = order.getStreetAddress();
		
		if (order.getStreetAddress2().trim().length() > 0) {
			address += " " + order.getStreetAddress2();
		}
		
		address += ", " + order.getCity() + ", " + order.getState();
		
		mview.addObject("email", order.getEmail());
		mview.addObject("phoneNumber", phoneNumber);
		mview.addObject("address", address);
		
		return mview;
	}

	@ModelAttribute("countryList")
	public Map<String, String> getCountryList() {
		Map<String, String> countryList = new HashMap<String, String>();

		countryList.put("CA", "Canada");
		countryList.put("CH", "China");
		countryList.put("MY", "Malaysia");
		countryList.put("PH", "Philippines");
		countryList.put("SG", "Singapore");
		countryList.put("US", "United States");

		return countryList;
	}
	
	@ModelAttribute("brandList")
	public Map<String, String> getBrandList() {
		Map<String, String> brandList = new HashMap<String, String>();

		brandList.put("Acer", "ACER");
		brandList.put("Asus", "ASUS");
		brandList.put("Dell", "DELL");
		brandList.put("HP", "HP");
		brandList.put("Macbook", "MACBOOK");

		return brandList;
	}
	
	private double getModelPrice(String brand, String model) {
		double modelPrice = 0.0;

		if (brand.equals("Acer")) {
			switch (model) {
			case "acer_nitro_5_17_3" :
				modelPrice = 1099.99;
				break;
			case "acer_predator_triton_14" :
				modelPrice = 1899.00;
				break;
			case "acer_aspire_5_15" :
				modelPrice = 799.99;
				break;
			}

		} else if (brand.equals("Asus")) {			
			switch (model) {
			case "asus_vivo_15" :
				modelPrice = 549.99;
				break;
			case "asus_rog_strix_g15_15" :
				modelPrice = 999.95;
				break;
			case "asus_tuf_dash_15" :
				modelPrice = 1599.99;
				break;
			}

		} else if (brand.equals("Dell")) {
			switch (model) {
			case "dell_inspiron_15" :
				modelPrice = 899.99;
				break;
			case "dell_inspiron_14" :
				modelPrice = 999.95;
				break;
			case "dell_xps_15" :
				modelPrice = 1799.00;
				break;
			}
		} else if (brand.equals("HP")) {		
			switch (model) {
			case "hp_envy_13_silver" :
				modelPrice = 1199.99;
				break;
			case "hp_omen_gaming_15" :
				modelPrice = 1599.95;
				break;
			case "hp_pavilion_gaming_15" :
				modelPrice = 799.99;
				break;
			}
		} else if (brand.equals("Macbook")) {
			switch (model) {
			case "macbook_air_13" :
				modelPrice = 1299.99;
				break;
			case "macbook_pro_13" :
				modelPrice = 1699.95;
				break;
			case "macbook_air_11" :
				modelPrice = 414.99;
				break;
			}
		}

		return modelPrice;
	}
	
	private String getModelLabel(String brand, String model) {
		String modelLabel = "";

		if (brand.equals("Acer")) {
			switch (model) {
			case "acer_nitro_5_17_3" :
				modelLabel = "Acer Nitro 5 17.3 inch";
				break;
			case "acer_predator_triton_14" :
				modelLabel = "Acer Predator Triton 300 SE 14 inch";
				break;
			case "acer_aspire_5_15" :
				modelLabel = "Acer Aspire 5 15.6 inch";
				break;
			}

		} else if (brand.equals("Asus")) {			
			switch (model) {
			case "asus_vivo_15" :
				modelLabel = "ASUS Vivobook 15.6 inch";
				break;
			case "asus_rog_strix_g15_15" :
				modelLabel = "ASUS ROG Strix G15 15.6 inch";
				break;
			case "asus_tuf_dash_15" :
				modelLabel = "ASUS TUF Dash 15 15.6 inch";
				break;
			}

		} else if (brand.equals("Dell")) {
			switch (model) {
			case "dell_inspiron_15" :
				modelLabel = "Dell Inspiron 15.6 inch";
				break;
			case "dell_inspiron_14" :
				modelLabel = "Dell Inspiron 5000 14 inch Touchscreen 2-in-1";
				break;
			case "dell_xps_15" :
				modelLabel = "Dell XPS 15 9510 15 inch";
				break;
			}
		} else if (brand.equals("HP")) {		
			switch (model) {
			case "hp_envy_13_silver" :
				modelLabel = "HP ENVY 13.3 inch - Natural Silver";
				break;
			case "hp_omen_gaming_15" :
				modelLabel = "HP OMEN 15.6 inch Gaming Laptop";
				break;
			case "hp_pavilion_gaming_15" :
				modelLabel = "HP Pavilion 15.6 inch Gaming Laptop";
				break;
			}
		} else if (brand.equals("Macbook")) {
			switch (model) {
			case "macbook_air_13" :
				modelLabel = "Apple MacBook Air 13.3 inch with Touch ID";
				break;
			case "macbook_pro_13" :
				modelLabel = "Apple MacBook Pro 13.3 inch with Touch Bar";
				break;
			case "macbook_air_11" :
				modelLabel = "Apple MacBook Air 11 inch";
				break;
			}
		}

		return modelLabel;
	}
}

