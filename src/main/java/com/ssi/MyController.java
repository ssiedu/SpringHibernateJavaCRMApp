package com.ssi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@Autowired
	CustomerDAO customerDAO;

	@RequestMapping("newcustomer")
	public String showCustomerEntryForm(){
		return "customerentry.jsp";
	}
	
	@RequestMapping("savecustomer")
	public String saveCustomerData(@ModelAttribute("customer") Customer customer){
		customerDAO.saveCustomer(customer);
		return "success.jsp";
	}

}
