package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Payment;
import com.nt.utility.HibernateUtil;

public class AnnoSaveTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Payment payment=null;
		int idVal=0;
		//get Session 
		ses=HibernateUtil.getSession();
		try {
			//begin  Tx
			tx=ses.beginTransaction();
			  //prepare Object
			payment=new Payment();
			payment.setPayId(9045);
			payment.setAmount(10000);
			payment.setPayMode("UPI");
			payment.setVendor("TAJ Krishna");
			//save object
			idVal=(int)ses.save(payment);
			System.out.println("Generated id value::"+idVal);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//Perform Tx Mgmt
				if(flag) {
					tx.commit();
					System.out.println("Objects is saved");
				}
				else {
					tx.rollback();
					System.out.println("Object is not saved");
				}
				
				//close Session
				HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();
				
			}//finally

	}//main
}//class
