package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class MergeTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null,p1=null,p3=null;
		boolean flag=false;
		
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//prepare object
		p=new Product();
		p.setPid(712); p.setPname("p-chair"); p.setPrice(900.55f);
		p.setQty(120); p.setStatus(true);
		//load the object
		p1=ses.get(Product.class, 712);
		
			 System.out.println(p1.getPid()+"  "+p1.getPname()+"  "+p1.getPrice()+"  "+p1.getQty()+" "+p1.isStatus());
			tx=ses.beginTransaction();
			  //ses.update(p);
			//ses.save(p);
			//ses.persist(p);
			//ses.delete(p);
			p3=(Product)ses.merge(p);
			System.out.println(p1.hashCode()+" "+p.hashCode()+"  "+p3.hashCode());
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