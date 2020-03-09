package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class DBTableRowToObjectSync {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null;
		boolean flag=false;
		//get Session obj
		ses=HibernateUtil.getSession();
		//get The object
		p=ses.get(Product.class, 789);
		System.out.println(p.getPid()+"  "+p.getPname()+"  "+p.getPrice()+"  "+p.getQty());
		System.out.println("==================");
		try {
			Thread.sleep(30000);  //Modify record from Db table during this sleep time
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ses.refresh(p);
		System.out.println(p.getPid()+"  "+p.getPname()+"  "+p.getPrice()+"  "+p.getQty());
		
	
		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class