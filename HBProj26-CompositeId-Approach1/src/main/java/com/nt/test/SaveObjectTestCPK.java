package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utility.HibernateUtil;

public class SaveObjectTestCPK {

	public static void main(String[] args) {
		Session ses=null;
		ProgrammerProjectInfo info=null,id=null;
		Transaction tx=null;
		boolean flag=false;
		// Get Session 
		ses=HibernateUtil.getSession();
		//prepare entity class object
		 info=new ProgrammerProjectInfo();
		 info.setPrgmrId(101); info.setProjId(1001);
		 info.setPrgmrName("raja"); info.setProjName("Proj1");
		 info.setCompany("HCL");
		 try {
			//begin Tx
			  tx=ses.beginTransaction();
			    //save object
			  id=(ProgrammerProjectInfo) ses.save(info);
			  System.out.println("generated id value::"+id.getPrgmrId()+" "+id.getProjId());
			  flag=true;
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
			 //perfform Tx mgmt
			  if(flag) {
				  tx.commit();
				  System.out.println("Object is saved");
			  }
			  else {
				  tx.rollback();
				  System.out.println("Object is not saved");
			  }
		 }//finally
	}//main
}//class
