package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private  static ThreadLocal<Session> threadLocal=new ThreadLocal();
	private static  SessionFactory factory=null;
	static {
		Configuration cfg=null;
		try {
			//Bootstap hiberante
			cfg=new Configuration();
			cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
			//create Session factory
			factory=cfg.buildSessionFactory();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}//static
	
	public  static  Session  getSession() {
		 Session  ses=null;
		 if(threadLocal.get()==null) {
			 ses=factory.openSession();
			 threadLocal.set(ses);
		 }
		 ses=threadLocal.get();
		 
		 return ses;
		
	}
	
	public static void closeSession() {
		Session ses=null;
		  if(threadLocal.get()!=null) {
			  ses=threadLocal.get();
			  ses.close();
			  threadLocal.remove();
		  }
	}
	
	public  static void closeSessionfactory() {
		 if(factory!=null)
			 factory.close();
	}

}
