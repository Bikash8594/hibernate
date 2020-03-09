package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class SaveObjectVersionTest {

	public static void main(String[] args) {
		Session ses=null;
		BankAccount account=null;
		long idVal=0;
		boolean flag=false;
		Transaction tx=null;
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare objecct
		account=new BankAccount();
		account.setBankName("SBI");
		account.setHolderName("raja");
		account.setBalance(9000);
		try {
			//begin tx
			 tx=ses.beginTransaction();
			//save object
			idVal=(long) ses.save(account);
			System.out.println("Generated id value::"+idVal);
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//perform Tx mgmt
			if(flag) {
				tx.commit();
				System.out.println("Object saved");
			}
			else {
				tx.rollback();
				System.out.println("Object not saved");
			}
				//close HB objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
			
		}//finally

	}//main
}//class
