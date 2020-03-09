package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		Configuration cfg=null;
		//boot strap hibernate
		cfg=new Configuration();
		//locate and read hiberante cfg file
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//build SessionFactory obj
		factory=cfg.buildSessionFactory();
	}
	
	public  static  Session getSession() {
		Session ses=null;
		  if(factory!=null)
			    ses=factory.openSession();
		  return ses;
	}
	
	public  static void closeSession(Session ses) {
		 if(ses!=null)
			 ses.close();
	}
	
	public  static  void closeSessionFactory() {
		 if(factory!=null)
			 factory.close();
	}
	
}
