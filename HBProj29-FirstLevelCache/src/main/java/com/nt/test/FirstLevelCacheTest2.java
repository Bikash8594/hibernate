package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Hospital;
import com.nt.utility.HibernateUtil;

public class FirstLevelCacheTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Hospital hospital=null;
		int idVal=0;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			//Load object
			hospital=ses.get(Hospital.class, 1);
            //modify object 
			hospital.setAddrs("Delhi");
             hospital.setAddrs("Delhi1");
             hospital.setCapacity(40);
             hospital.setContactNo(34343434L);
			flag=true;
		}
		catch(HibernateException he) {
			 flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object updated");
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
