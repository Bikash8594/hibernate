package com.nt.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class SaveObjectTest {

	public static void main(String[] args)throws Exception {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		
		//create Configuration  object
	   cfg=new Configuration();
	   //set Hb properties
	   cfg.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
	   cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
	   cfg.setProperty("hibernate.connection.username", "system");
	   cfg.setProperty("hibernate.connection.password", "manager");
	   cfg.setProperty("hibernate.show_sql", "true");
	   cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	   
		//add mapping file
		cfg.addFile("src/com/nt/entity/Employee.hbm.xml");
		//build SessionFactory
		factory=cfg.buildSessionFactory();
		// create Session
		ses=factory.openSession();
		//create Entity class object
		emp=new Employee();
		 emp.setEname("raja");
		 emp.setEadd("hyd");emp.setEsalary(9000.0f);
		//save Object
		try {
			//begin Tx
			tx=ses.beginTransaction();   //calls  con.setAutoCommit(false) to begin Tx
			    idVal=(Integer) ses.save(emp);
			    System.out.println("Generated id value::"+idVal);
			    flag=true;
		}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			//perform Tx mgmt
			if(flag) {
				tx.commit(); //commits Tx by calling con.commit()
				System.out.println("Object is saved (Record in inserted) ");
			}
			else {
				tx.rollback(); //rollbacks Tx by calling con.rollback() 
				System.out.println("Object is not saved (Record not inserted)");
			}
			//close objs
			ses.close();   //close the connection with Db s/w
			factory.close(); // releases all services that are hold by factory   and deactivates  HB f/w
		}//finally  */

	}//main
}//class
