package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class DeleteObjectTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null;
		boolean flag=false;
		//get Session obj
		ses=HibernateUtil.getSession();
		//Load object
		p=ses.get(Product.class,980);
		if(p!=null) {
			System.out.println("record found::");
			System.out.println(p.getPid()+"  "+p.getPname()+"  "+p.getPrice()+" "+p.getQty());
		//delete object
		try {
			tx=ses.beginTransaction();
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
		  }//finally
		}
		else {
			System.out.println("record not found");
		}
		
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();


	}//main
}//class