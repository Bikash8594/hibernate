package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public Product getProduct(int pid) {
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		tx=ses.beginTransaction();
		System.out.println("ProductDAOImpl.getProduct():: ses hashCode::"+ses.hashCode());
		//Load object
		prod=ses.get(Product.class, pid);
	  	return prod;	
	  	
	}
	
	

}
