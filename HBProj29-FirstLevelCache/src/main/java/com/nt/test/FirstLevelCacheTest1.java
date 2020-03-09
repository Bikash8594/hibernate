package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Hospital;
import com.nt.utility.HibernateUtil;

public class FirstLevelCacheTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Hospital hospital=null;
		int idVal=0;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare object
		hospital=new Hospital();
		hospital.setHospitalName("PRIME");
		hospital.setAddrs("HYD");
		hospital.setCapacity(4);
		hospital.setContactNo(99999999L);
		
		try {
			tx=ses.beginTransaction();
			
             idVal=(int) ses.save(hospital);	
             hospital.setAddrs("Delhi");
             hospital.setAddrs("Delhi1");
             hospital.setCapacity(40);
			   System.out.println("Generated id value::"+idVal);
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
				System.out.println("Object saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
				
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
