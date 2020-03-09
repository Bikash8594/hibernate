package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class LoadObjectVersionTest {

	public static void main(String[] args) {
		Session ses=null;
		BankAccount account=null;
		long idVal=0;
		boolean flag=false;
		Transaction tx=null;
		//get Session 
		ses=HibernateUtil.getSession();
		try {
			//begin tx
			 tx=ses.beginTransaction();
				//Load object
				account=ses.get(BankAccount.class,3L);
				if(account==null)
					return;
		    //modify the loaded
			 account.setBalance(63190);
			 
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
				System.out.println("Object is modified for "+account.getOperationsCount()+" times");
			}
			else {
				tx.rollback();
			}
				//close HB objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
			
		}

	}

}
