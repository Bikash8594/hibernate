package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class HQLUpdateTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		int result=0;
		boolean flag=false;
		// get Session object
		ses = HibernateUtil.getSession();
		try {
			//prepare Query object
			query=ses.createQuery("update Product set price=price+:price where price>=:range ");
			//set query poaram values
			query.setParameter("price",1000.0f);
			query.setParameter("range",10000.0f);
			//Begin  Tx
			  tx=ses.beginTransaction();
			    result=query.executeUpdate();
			    flag=true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag=false;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		} finally {
			
			//Tx mgmt
			if(flag==true) {
				tx.commit();
				 System.out.println("Object updated");
			}
				 else {
					 tx.rollback();
					 System.out.println("object is not updated");
				 }
			// close Session
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}// main
}// class
