package com.nt.test;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<Product> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//get Access to Named HQL query
			query=ses.getNamedQuery("GET_PRODUCTS_BY_PRICE_RANGE");
			//set values to query params
			query.setParameter("min",1000.0f);
			query.setParameter("max",20000.0f);
			//execute the query
			list=query.getResultList();
			//process the results
			list.forEach(p->{
				System.out.println(p);
			});
		}//tru
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}//main

}//class
