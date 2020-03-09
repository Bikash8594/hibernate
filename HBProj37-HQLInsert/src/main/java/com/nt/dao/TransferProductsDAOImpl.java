package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class TransferProductsDAOImpl implements TransferProductsDAO {
   private static  final String  HQL_INSERT_QUERY="INSERT INTO PremiumProduct(pid,pname,price,qty,status) SELECT  p.pid,p.pname,p.price,p.qty,p.status FROM Product as p WHERE p.price>=:min and p.price<=:max";  
	@Override
	public int transferProducts(float startPrice, float endPrice) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		// get Session
		ses=HibernateUtil.getSession();
		try {
		//preparae Query object
		query=ses.createQuery(HQL_INSERT_QUERY);
		//set values to query params
		query.setParameter("min",startPrice);
		query.setParameter("max",endPrice);
		//begin Tx 
		   tx=ses.beginTransaction();
		   //execute query
		  count=query.executeUpdate();
		  flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//perform Tx mgmt
			if(flag) {
				tx.commit();
			}
			else {
				tx.rollback();
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//try
		return count;
	}//method
}//class
