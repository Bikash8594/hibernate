package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest5 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null;
		boolean flag=false;
		//get Session obj
		ses=HibernateUtil.getSession();
		//get The object
		//p=(Product) ses.get(Product.class,789);
		p=new Product();
		p.setPid(756);
		if(p!=null) {
			try {
				tx=ses.beginTransaction();
			//modify object
			p.setPrice(2300);
		    ses.save(p);
		    flag=true;
		   System.out.println("record found and modified");
			}
			catch(Exception e) {
				e.printStackTrace();
				flag=false;
			}
			finally {
				if(flag) {
					tx.commit();
					System.out.println("Tx committed-Object updated");
				}
				else {
					tx.rollback();
					System.out.println("Object not updated");
				}
					
			}
		}//if
		else {
			System.out.println("record not found");
		}

		//close objs
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class