package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProgrammerProjectId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utility.HibernateUtil;

public class SaveObjectTestCPK {

	public static void main(String[] args) {
		Session ses=null;
		ProgrammerProjectInfo info=null;
		Transaction tx=null;
		boolean flag=false;
		ProgrammerProjectId id=null,idVal=null;
		// Get Session 
		ses=HibernateUtil.getSession();
		//prepare Id class object
		id=new ProgrammerProjectId();
		id.setPrgmrId(102); id.setProjId(1002); 
		//prepare entity class object
		
		 info=new ProgrammerProjectInfo();
		 info.setId(id);
		 info.setPrgmrName("raja"); info.setProjName("Proj1");
		 info.setCompany("HCL");
		 try {
			//begin Tx
			  tx=ses.beginTransaction();
			    //save object
			  idVal= (ProgrammerProjectId) ses.save(info);
			  System.out.println("generated id value::"+idVal.getPrgmrId()+" "+idVal.getProjId());
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
