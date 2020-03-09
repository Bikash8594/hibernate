package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
    static {
    	 Configuration cfg=null;
    	try {
    		//create Configuration object
    		 cfg=new Configuration();
    		 cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
    		 factory=cfg.buildSessionFactory();
    	}//try
    	catch(HibernateException he) {
    		he.printStackTrace();
    	}
    }//static
    
    public   static  Session getSession() {
    	Session ses=null;
    	//open session
    	if(factory!=null)
    		ses=factory.openSession();
    	return ses;
    }
    
    public static void  closeSession(Session ses) {
    	if(ses!=null)
    		ses.close();
    }
    
    public  static void  closeSessionFactory() {
    	if(factory!=null)
    		  factory.close();
    }
}
