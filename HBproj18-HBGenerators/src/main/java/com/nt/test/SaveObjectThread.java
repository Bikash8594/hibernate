package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class SaveObjectThread implements Runnable {

	@Override
	public void run() {
		
		Session ses=null;
		Product prod=null;
		int idVal=0;
		boolean flag=false;
		Transaction tx=null;
		System.out.println(Thread.currentThread());
		//get Session
	   ses=HibernateUtil.getSession();
	   //prepare object
	   prod=new Product();
	   prod.setPname("chair");
	   prod.setPrice(9000);
	   prod.setQty(90);
	   prod.setStatus(true);
	   try {
		   //begin Tx
		   tx=ses.beginTransaction();
		   //save object
		  idVal=(int) ses.save(prod);
		  System.out.println("Generated id value::"+idVal);
		  flag=true;
	   }//try
	   catch(HibernateException he) {
		   he.printStackTrace();
	   }
	   finally {
		   //tx mgmt
		   if(flag) {
			   tx.commit();
		   }
		   else {
			   tx.rollback();
		   }
	   }//finally
	}//run

}//class
