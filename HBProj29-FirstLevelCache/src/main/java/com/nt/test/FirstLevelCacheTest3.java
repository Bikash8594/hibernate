package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Hospital;
import com.nt.utility.HibernateUtil;

public class FirstLevelCacheTest3 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Hospital hospital1=null,hospital2=null;
		int idVal=0;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			//Load object
			hospital1=ses.get(Hospital.class, 1);
			System.out.println(hospital1);
			System.out.println(".................................");
			//ses.evict(hospital1);
			ses.clear();
            //Load object again 
			hospital2=ses.get(Hospital.class, 1);
			System.out.println(hospital2);
			
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
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
