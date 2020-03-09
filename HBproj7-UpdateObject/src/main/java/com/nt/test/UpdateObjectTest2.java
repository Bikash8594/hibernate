package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null;
		boolean flag=false;
		//get Session obj
		ses=HibernateUtil.getSession();
		//get The object
		p=ses.get(Product.class,789);
		if(p!=null) {
		try {
			tx=ses.beginTransaction();
			//modify object
			p.setPrice(5000);
			   ses.update(p);
			  flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is updated");
			}
			else {
				tx.rollback();
				System.out.println("Object is not updated");
			}
			
		}//finally
		}//if
		else {
			System.out.println("record not found");
		}

		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class