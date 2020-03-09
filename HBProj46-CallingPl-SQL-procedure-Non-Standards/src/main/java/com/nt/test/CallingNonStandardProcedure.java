package com.nt.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.nt.utility.HibernateUtil;

public class CallingNonStandardProcedure {

	public static void main(String[] args) {
		Session ses=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//use Callback interface ReturningWork to call PL/SQL procedure using CallableStatement object
		String result=ses.doReturningWork(new MyReturningWork());
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
	
	private static class  MyReturningWork  implements ReturningWork<String>{

		@Override
		public String execute(Connection con) throws SQLException {
			CallableStatement cs=null;
			String result=null;
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
				result=cs.getString(3);
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}//execute(-)
	}//inner class
	
}//outer class
