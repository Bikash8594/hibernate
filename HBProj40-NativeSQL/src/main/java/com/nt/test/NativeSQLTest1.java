package com.nt.test;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class NativeSQLTest1 {

	public static void main(String[] args) {
		Session ses=null;
		NativeQuery query=null;
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		//get Session object
		ses=HibernateUtil.getSession();
		
		try {
			//begin the Tx
			tx=ses.beginTransaction();
			 //preprae NativeQuery object
			query=ses.createSQLQuery("INSERT INTO PROJECT VALUES(?,?,?,?,?)");
			//set query param values
			query.setParameter(1,8901);
			query.setParameter(2,"AirBus");
			query.setParameter(3,"Automobile");
			query.setParameter(4,"Verizon");
			query.setParameter(5,10);
			//execute the query
			count=query.executeUpdate();
			if(count==0)
				System.out.println("Record not inserted");
			else
				System.out.println("record inserted");
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				
			}
			else {
				tx.rollback();
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}//main
}//class
