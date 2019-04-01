package com.ssi;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;	

	
	public List<Customer> getAllCustomers(){
		String hql="from Customer";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		List<Customer> customerList=query.list();
		session.close();
		return customerList;
	}
	
	public void saveCustomer(Customer customer){
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(customer);
		tr.commit();
		session.close();
	}
}
