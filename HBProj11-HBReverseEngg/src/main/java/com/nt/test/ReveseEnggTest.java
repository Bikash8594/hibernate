package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class ReveseEnggTest {

	public static void main(String[] args) {
		Session ses=null;
		Employee emp=null;
		//get SEssion
		ses=HibernateUtil.getSession();
		try {
		//Load object
		emp=ses.get(Employee.class,(long)1001);
		if(emp!=null) {
			System.out.println(emp.getEid()+" "+emp.getEname()+" "+emp.getSalary()+"  "+emp.getEadd());
		}
		else {
			System.out.println("record not found");
		}
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
		
	}

}
