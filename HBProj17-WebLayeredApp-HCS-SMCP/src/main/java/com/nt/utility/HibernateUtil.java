package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
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
			 ses=factory.getCurrentSession();
		 return ses;
		
	}
	

	
	public  static void closeSessionfactory() {
		 if(factory!=null)
			 factory.close();
	}

}
