package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class ProcedureCallTest {

	public static void main(String[] args) {
		Session ses=null;
	    Query query=null;
		List<Product> list=null;
		//get SEssion
		ses=HibernateUtil.getSession();
		try {
		//get Access to NamedSQL Query
		query=ses.getNamedQuery("CALL_PROCEDURE");
		//set values to IN params
			query.setParameter(1,1000);
			query.setParameter(2, 10000);
			/*	query.setParameter("start",1000);
				query.setParameter("end", 10000);*/
		//call PL/SQL procedure
		list=query.list();
		//process the results
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
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
	}//main
}//class
