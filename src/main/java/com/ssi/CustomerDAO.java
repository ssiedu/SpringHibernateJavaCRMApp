package com.ssi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;	
	
	public void saveCustomer(Customer customer){
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(customer);
		tr.commit();
		session.close();
	}
}
