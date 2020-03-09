package com.nt.utility;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.service.internal.StandardServiceRegistryImpl;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;

import com.nt.service.UserConnectionProvider;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		Configuration cfg=null;
		ServiceRegistryBuilder builder=null;
		ServiceRegistry registry=null;
		UserConnectionProvider provider=null;
		//boot strap hibernate
		cfg=new Configuration();
		//locate and read hiberante cfg file
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//create ServiceRegistryBuilder
		builder=new ServiceRegistryBuilder();
		 //add CustomService
		provider=new UserConnectionProvider();
		builder.addService(ConnectionProvider.class, provider);
		//create ServiceRegistry
		registry= builder.applySettings(cfg.getProperties()).buildServiceRegistry();
        
		//build SessionFactory obj
		factory=cfg.buildSessionFactory(registry);
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
