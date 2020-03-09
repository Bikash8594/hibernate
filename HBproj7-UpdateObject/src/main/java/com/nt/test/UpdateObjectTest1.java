package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null;
		boolean flag=false;
		//get Session obj
		ses=HibernateUtil.getSession();
		//update object
		p=new Product();
		p.setPid(789);
		p.setPname("chair");
		//p.setPrice(9340);
		//p.setQty(2);
		p.setStatus(true);
		try {
			tx=ses.beginTransaction();
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
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class