package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class MergeTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null,p1=null;
		boolean flag=false;
		
		//get Session
		ses=HibernateUtil.getSession();
		//prepare object
		p=new Product();
		p.setPid(720); p.setPname("chair"); p.setPrice(900.55f);
		p.setQty(12); p.setStatus(true);
		try {
			tx=ses.beginTransaction();
			  p1=(Product) ses.merge(p);
			  System.out.println(p.hashCode()+"  "+p1.hashCode());
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Tx Committed--Object is saved/updated");
			}
			else {
				tx.rollback();
				System.out.println("Tx RolledBack --Object is not saved/updated");
			}
				//close HB object
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class