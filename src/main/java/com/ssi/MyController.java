package com.ssi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@Autowired
	CustomerDAO customerDAO;

	
	@RequestMapping("delete")
	public void removeCustomer(@RequestParam("code") String code){
		System.out.println("You Wish To Delete "+code);
	}
	
	@RequestMapping("showall")
	public ModelAndView showAllCustomers(){
		//fetch the list of all customers using DAO
		List<Customer> customerList=customerDAO.getAllCustomers();
		//will forward the request to a view
		ModelAndView mv=new ModelAndView("showallcustomers.jsp");
		mv.addObject("customers", customerList);
		return mv;
	}
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
