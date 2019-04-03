package com.ssi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entities.Customer;

@Component
public class CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;	

	public Customer getCustomerById(String code){
		Session session=sessionFactory.openSession();
		Customer customer=session.get(Customer.class, code);
		session.close();
		return customer;
	}
	
	public void deleteCustomer(String code){
		Customer customer=new Customer();
		customer.setCode(code);
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(customer);
		tr.commit();
		session.close();
	}
	public List<Customer> getAllCustomers(){
		String hql="from Customer";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		List<Customer> customerList=query.list();
		session.close();
		return customerList;
	}
	
	public void saveOrUpdateCustomer(Customer customer){
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(customer);
		tr.commit();
		session.close();
	}
}
