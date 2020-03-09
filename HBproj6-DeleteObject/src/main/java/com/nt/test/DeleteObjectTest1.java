package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class DeleteObjectTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null;
		boolean flag=false;
		//get Session obj
		ses=HibernateUtil.getSession();
		//delete object
		try {
			tx=ses.beginTransaction();
			  p=new Product();
			  p.setPid(953);
			  ses.delete(p);
			  flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is Deleted");
			}
			else {
				tx.rollback();
				System.out.println("Object is not Deleted");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class