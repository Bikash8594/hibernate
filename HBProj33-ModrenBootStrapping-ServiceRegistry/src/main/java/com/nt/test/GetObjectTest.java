package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class GetObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//Load object
			policy=(InsurancePolicy) ses.get(InsurancePolicy.class,1001);
			if(policy!=null) {
				 System.out.println(policy.getPolicyId()+"  "+policy.getPolicyName()+"  "+policy.getCompany()+" "+policy.getPolicyType()+"  "+policy.getTenure());
			}
			else {
				System.out.println("Object not found");
			}
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close  objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}//main
}//class
