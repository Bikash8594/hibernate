package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.IInsurance;
import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		IInsurance policy=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//Load object
			policy=ses.load(InsurancePolicy.class,9010);
			System.out.println(policy.getClass()+" "+policy.getClass().getSuperclass()+"  "+Arrays.deepToString(policy.getClass().getInterfaces())+Arrays.deepToString(policy.getClass().getDeclaredMethods()));
			//System.out.println(policy.getPolicyId());
			//System.out.println(policy.getPolicyName());
			System.out.println(policy.getPolicyType());
			
				// System.out.println(policy.getPolicyId()+"  "+policy.getPolicyName()+"  "+policy.getCompany()+" "+policy.getPolicyType()+"  "+policy.getTenure());
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
