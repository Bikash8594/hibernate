package com.nt.test;

import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.IPayment;
import com.nt.entity.Payment;
import com.nt.utility.HibernateUtil;

public class AnnoLoadTest {

	public static void main(String[] args) {
		Session ses=null;
		IPayment payment=null;
		//get Session 
		ses=HibernateUtil.getSession();
		try {
			//Load object
			//payment=ses.get(Payment.class,9034);
			payment=ses.load(Payment.class,9034);
			System.out.println(payment.getClass()+"  "+payment.getClass().getSuperclass()+" "+ Arrays.toString(payment.getClass().getInterfaces()));
				//System.out.println(payment);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close HB objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}//main
}//class
