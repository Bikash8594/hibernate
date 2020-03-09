package com.nt.test;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class PaginationHQLTest {

	public static void main(String[] args) {
	   Session ses=null;
	   Query query=null;
	   List<Product> list=null;
	   //get Session
	   ses=HibernateUtil.getSession();
	   try {
	   //prepare Query object
	   query=ses.getNamedQuery("GET_ALL_PRODUCTS");
	   //set pagination params
	   query.setFirstResult(7);
	   query.setMaxResults(3);
	   //execute the Query
	   list=query.getResultList();
	   //process result
	   list.forEach(p->{
		   System.out.println(p);
	   });
	   }//try
	   catch(HibernateException he) {
		   he.printStackTrace();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   finally {
		   //close jdbc objs
		   HibernateUtil.closeSession(ses);
		   HibernateUtil.closeSessionFactory();
	   }

	}

}
