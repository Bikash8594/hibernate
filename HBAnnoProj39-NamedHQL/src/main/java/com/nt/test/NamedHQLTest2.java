package com.nt.test;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		int  count=0;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			//get Access to Named HQL query
			query=ses.getNamedQuery("DELETE_PRODUCTS_BY_PRICE_RANGE");
			//set values to query params
			query.setParameter("range",100.0f);
			//execute the query
			count=query.executeUpdate();
			flag=true;
		}//tru
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//Tx Mgmt
			 if(flag) {
				 tx.commit();
				 System.out.println("Tx is committed  and "+count+" no.of records are deleted");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Tx is rolled back and record not deleted ");
			 }
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
