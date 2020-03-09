package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class NamedNativeSQLTest {

	public static void main(String[] args) {
		Session ses = null;
		NativeQuery<Project> query = null;
		NativeQuery<Integer> query1 = null;
		NativeQuery<Object[]> query2 = null;
		List<Project> list = null;
		List<Object[]> list1 = null;
		Transaction tx = null;
		int count = 0;
		boolean flag = false;
		// get Session object
		ses = HibernateUtil.getSession();
		try {
			// prepare NativeQuery object
			query = ses.getNamedNativeQuery("GET_PROJECTS_BY_TEAM_SIZE_RANGE");
			// set query param values
			query.setParameter("min", 5);
			query.setParameter("max", 10);
			// execute the Query
			list = query.getResultList();
			// process the Results
			list.forEach(p -> {
				System.out.println(p);
			});
			/*		// get Access to Named NativeSQL Query
					query1 = ses.getNamedNativeQuery("STREAMLINE_TEAMSIZE");
					// set query param values
					query1.setParameter("correction", 2);
					query1.setParameter("size", 15);
					// begin Tx
					tx = ses.beginTransaction();
					// execute the Query
					count = query1.executeUpdate();
					System.out.println("no.of Projects that are effected::" + count);*/

			// get Access to Named NativeSQL Query
			/*		query2=ses.getNamedNativeQuery("GET_PROJECTS_INFO_BY_DOMAIN_NAME");
					query2.addScalar("PROJNAME",StandardBasicTypes.STRING);
					query2.addScalar("TEAMSIZE",StandardBasicTypes.INTEGER);
					//set query param values
					query2.setParameter("dmn","e%");
					//execute the query
					list1=query2.getResultList();
					//process the result
					list1.forEach(row->{
						 for(Object val:row) {
							 System.out.print(val+"  ");
						 }
						 System.out.println();
					});*/
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// perform Tx mgmt
			if (flag) {
				tx.commit();
			} else {
				tx.rollback();
			}
			// close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		} // finally
	}// main
}// class
