package com.nt.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;



public class CustomNITGenerator implements IdentifierGenerator {
  private static final String  CALL_SEQ="SELECT NIT_SEQ.NEXTVAL FROM DUAL";
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int val=0;
		String idVal=null;
		try {
		//get jdbc con object
		con=session.connection();
		//create PreparedStatement obj having pre-compiled SQL Query
		ps=con.prepareStatement(CALL_SEQ);
		//execute the Query
		rs=ps.executeQuery();
		//process the ResultSet and get value
		rs.next();
		 val=rs.getInt(1);
		 
		 if(val<=9)
			 idVal="NIT000"+val;
		 else if(val<=99)
			 idVal="NIT00"+val;
		 else if(val<=999)
			 idVal="NIT0"+val;
		 else
			 idVal="NIT"+val;
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			/*
			 * try { if(con!=null) con.close(); } catch(SQLException se) {
			 * se.printStackTrace(); }
			 */
		}//finally
		
		return idVal;
	}//method
}//class
