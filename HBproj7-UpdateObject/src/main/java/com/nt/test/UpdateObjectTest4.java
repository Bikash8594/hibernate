package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest4 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null;
		boolean flag=false;
		//get Session obj
		ses=HibernateUtil.getSession();
		//get The object
		p=(Product) ses.get(Product.class,789);
		if(p!=null) {
			//modify object
			p.setPrice(8000);
		   ses.flush();
		   System.out.println("record found and modified");
		}//if
		else {
			System.out.println("record not found");
		}

		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class