package com.nt.test;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class NativeSQLTest {

	public static void main(String[] args) {
		Session ses=null;
		NativeQuery<Project> query=null;
		NativeQuery<Object[]> query1=null;
		NativeQuery<Object> query2=null;
		NativeQuery<Integer> query3=null;
		List<Project> list=null;
		List<Object[]> list1=null;
		List<Object> list2=null;
		List<Integer> list3=null;
		//SQLQuery query=null;
		//get Session object
		ses=HibernateUtil.getSession();
		try {
			//create NativeQuery object having native SQL query (Entity Query)
			/*	query=ses.createNativeQuery("SELECT PROJID,PROJNAME,DOMAIN,COMPANY,TEAMSIZE FROM PROJECT  WHERE TEAMSIZE>=?3 AND TEAMSIZE<=?4");
				//set query param  values
				query.setParameter(3,10);
				query.setParameter(4, 20);
				//map results with Entity class
				query.addEntity(Project.class);
				//execute the Query
				list=query.getResultList();
				//process the Result
				list.forEach(p->{
					System.out.println(p);
				});*/
			
			/*	  //NativeQuery  getting specific multiple col values (scalar query)
				  query1=ses.createSQLQuery("SELECT PROJID,PROJNAME FROM PROJECT WHERE PROJID>=:min AND PROJID<=:max");
				  //set query param values
				  query1.setParameter("min",1000);
				  query1.setParameter("max",2000);
				  //map cols with hibernate types
				  query1.addScalar("PROJID",StandardBasicTypes.INTEGER);
				  query1.addScalar("PROJNAME",StandardBasicTypes.STRING);
				  //execute query
				  list1=query1.list();
				  //process the result
				  list1.forEach(row->{
					  for(Object val:row) {
						   System.out.print(val+"  ");
					  }//for
					  System.out.println();
				  });*/
			/*	 // getting specific single col value (scalar query)
				query2=ses.createSQLQuery("SELECT PROJNAME FROM PROJECT WHERE PROJNAME LIKE :initChars");
				//set query param values
				query2.setParameter("initChars","a%");
				//map results with  HB data types
				query2.addScalar("PROJNAME",StandardBasicTypes.STRING);
				//execute the query
				list2=query2.list();
				//process the Result
				list2.forEach(proj->{
					System.out.println(proj);
				});
				*/
			 // getting aggragate result (scalar query)
			query3=ses.createSQLQuery("SELECT COUNT(*) FROM PROJECT");
			//map results with  HB data types
			query3.addScalar("COUNT(*)",StandardBasicTypes.INTEGER);
			//execute the query
			list3=query3.list();
			//process the Result
			System.out.println("count of  records in Db table::"+list3.get(0));
			
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
