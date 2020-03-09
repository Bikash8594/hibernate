package com.nt.dao;

import org.hibernate.Session;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public Product getProduct(int pid) {
		Session ses=null;
		Product prod=null;
		//get Session
		ses=HibernateUtil.getSession();
		System.out.println("ProductDAOImpl.getProduct():: ses hashCode::"+ses.hashCode());
		//Load object
		prod=ses.get(Product.class, pid);
	  	return prod;	
	  	
	}
	
	

}
