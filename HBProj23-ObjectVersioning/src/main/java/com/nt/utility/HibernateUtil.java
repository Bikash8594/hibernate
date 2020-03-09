package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static  SessionFactory factory;
	
	static {
       try {
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
       }
       catch(HibernateException he) {
    	   he.printStackTrace();
       }
	}
	
	 public  static  Session getSession() {
		 Session ses=null;
		   if(factory!=null)
			   ses=factory.getCurrentSession();
		   return ses;
		 
	 }
	 
	 public  static  void closeSession(Session ses) {
		   if(ses!=null)
			   ses.close();
	 }
	 
	 public  static  void closeSessionFactory() {
		  if(factory!=null)
			  factory.close();
	 }

}
