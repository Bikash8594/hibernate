package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class SaveOrUpdateObjectTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare object
		p=new Product();
		 p.setPid(789);p.setPname("raja"); p.setPrice(900.55f);
		p.setQty(89); p.setStatus(true);
		try {
			tx=ses.beginTransaction();
			   ses.saveOrUpdate(p);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Tx Committed--Object is saved/update");
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