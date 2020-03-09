package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProgrammerProjectId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utility.HibernateUtil;

public class LoadObjectTestCPK {

	public static void main(String[] args) {
		Session ses=null;
		ProgrammerProjectInfo info=null;
		ProgrammerProjectId id=null;
		Transaction tx=null;
		boolean flag=false;
		// Get Session 
		ses=HibernateUtil.getSession();
		//prepare id value
		id=new ProgrammerProjectId();
		id.setPrgmrId(103); id.setProjId(1003);
		 try {
			//begin Tx
			  tx=ses.beginTransaction();
			   //Load object Test
				info=ses.get(ProgrammerProjectInfo.class, id);
				System.out.println(info);
		 }
		 catch(HibernateException he) {
			 he.printStackTrace();
			 flag=false;
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 flag=false;
		 }
		 finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
			
		 }//finally
	}//main
}//class
