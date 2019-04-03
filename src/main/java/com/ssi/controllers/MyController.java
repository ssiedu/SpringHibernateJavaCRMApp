package com.ssi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.CustomerDAO;
import com.ssi.entities.Customer;

@Controller
public class MyController {

	@Autowired
	CustomerDAO customerDAO;

	@RequestMapping("savechanges")
	public ModelAndView saveChanges(@ModelAttribute("customer") Customer customer){
		customerDAO.saveOrUpdateCustomer(customer);
		ModelAndView mv=new ModelAndView("redirect:showall");
		return mv;
	}
	
	
	
	
	@RequestMapping("update")
	public ModelAndView showUpdateForm(@RequestParam("code") String code){
		
		//fetch a customer object using id
		Customer customer=customerDAO.getCustomerById(code);
		//create a ModelAndView object and add customer object to it
		ModelAndView mv=new ModelAndView("customerupdate-new");
		mv.addObject("customer", customer);
		return mv;
		
	}
	
	@RequestMapping("delete")
	public ModelAndView removeCustomer(@RequestParam("code") String code){
		customerDAO.deleteCustomer(code);
		ModelAndView mv=new ModelAndView("redirect:showall");
		return mv;
	}
	
	@RequestMapping("showall")
	public ModelAndView showAllCustomers(){
		//fetch the list of all customers using DAO
		List<Customer> customerList=customerDAO.getAllCustomers();
		//will forward the request to a view
		ModelAndView mv=new ModelAndView("showallcustomers");
		mv.addObject("customers", customerList);
		return mv;
	}
	@RequestMapping("newcustomer")
	public String showCustomerEntryForm(){
		return "customerentry";
	}
	
	@RequestMapping("savecustomer")
	public String saveCustomerData(@ModelAttribute("customer") Customer customer){
		customerDAO.saveOrUpdateCustomer(customer);
		return "success";
	}

}
