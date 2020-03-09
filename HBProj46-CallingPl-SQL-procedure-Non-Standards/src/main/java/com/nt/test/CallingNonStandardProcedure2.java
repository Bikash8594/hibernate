package com.nt.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.nt.utility.HibernateUtil;

public class CallingNonStandardProcedure2 {

	public static void main(String[] args) {
		Session ses=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//use Callback interface ReturningWork to call PL/SQL procedure using CallableStatement object
		String result=ses.doReturningWork(con->{
				CallableStatement cs=null;
				String res=null;
				try {
					//create CalalbleStatement object
					cs=con.prepareCall("{CALL P_AUTHENTICATION(?,?,?) }");
					//register out params with jdbc data types
					cs.registerOutParameter(3, Types.VARCHAR);
					//set values to IN Params
					cs.setString(1,"raja");
					cs.setString(2,"rani");
					//call Pl/SQL procedure
					cs.execute();
					//gather result from OUt param
					res=cs.getString(3);
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return res;
			});
		
		System.out.println("Result::"+result);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close  objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}//main
	
}//outer class
