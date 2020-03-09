package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class FunctionCallTest {

	public static void main(String[] args) {
		Session ses=null;
	    Query query=null;
		List<Object[]> list=null;
		//get SEssion
		ses=HibernateUtil.getSession();
		try {
		//get Access to NamedSQL Query
		query=ses.getNamedQuery("CALL_FUNCTION");
		//set IN param value
		query.setParameter(1,"e%");
		//call PL/SQL procedure
		list=query.list();
		//process the results
		list.forEach(row->{
			for(Object val: row) {
				System.out.print(val+"  ");
			}
			System.out.println();
		});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}//main
}//class
