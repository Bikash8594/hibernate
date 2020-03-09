package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest {

	public static void main(String[] args) {
		Session ses = null;
		Query query = null;
		List<Product> list = null;
		Iterator<Product> it = null;
		List<Object[]> list1 = null;
		Iterator<Object[]> it1 = null;
		List<String > list2=null;
		List<Integer> list3=null;
		List<Object[]> list4=null;
		// get Session object
		ses = HibernateUtil.getSession();
		try {
			// prepare Query object
			// query=ses.createQuery("from Product");
			// execute Query
			/*list=query.list();
			//process result
				list.forEach(p->{
					System.out.println(p);
				});*/

			// execute query
			/*it=query.iterate();
					while(it.hasNext()) {
						Product p=it.next();
						System.out.println(p);
					}*/
			System.out.println(".........................................");
			/*	  //executing HQL Query with condition having positional params
				//query=ses.createQuery("from Product  where pid>=? and pid<=?");
				query=ses.createQuery("from Product  where pid>=?1 and pid<=?2");
				//set query param values
				query.setParameter(1,100);
				query.setParameter(2,200);
				//execute Query
				//list=query.getResultList();
				list=query.list();
				//process the results
				list.forEach(p->{
					System.out.println(p);
				});*/

			// executing HQL Query with condition having positional params
			// query=ses.createQuery("from Product where pid>=? and pid<=?");
			/*query=ses.createQuery("from Product  where pid>=:min and pid<=?1");
			//set query param values
			query.setParameter("min",100);
			query.setParameter(1,200);
			//execute Query
			//list=query.getResultList();
			list=query.list();
			//process the results
			list.forEach(p->{
				System.out.println(p);
			});*/

			/*	// executing HQL query that gives specific multiple col values..
						query=ses.createQuery("select pid,pname,price from Product where pname in(:prod1,:prod2)");
						//set query param values
						query.setParameter("prod1","table");
						query.setParameter("prod2", "chair");
						//execute the query
						list1=query.getResultList();
						//process the Result
						list1.forEach(row->{
							for(Object val:row) {
								System.out.print(val+"  ");
							}
							System.out.println();
						});
						it1=query.iterate();
						while(it1.hasNext()) {
							Object row[]=it1.next();
							for(Object val:row) {
								System.out.print(val+" ");
							}
							System.out.println();
						}
						*/
			/*		//executing HQL Query giving specific single col value
					query=ses.createQuery("select pname  from Product where price>=:min and price<=:max");
					query.setParameter("min",10000.0f);
					query.setParameter("max",100000.0f);
					list2=query.getResultList();
					list2.forEach(name->{
						System.out.println(name);
					});*/
			
			/*	//executing HQL Select Query with aggrated results.
				query=ses.createQuery("select count(*) from Product");
				list3=query.getResultList();
				System.out.println("count of records ::"+list3.get(0));
				*/
			/*	//executing HQL Select Query with multiple aggrated results.
				query=ses.createQuery("select count(*),max(price),min(price)  from Product");
				list4=query.getResultList();
				Object row[]=list4.get(0);
				System.out.println("count::"+row[0]);
				System.out.println("max price::"+row[1]);
				System.out.println("min price::"+row[2]);*/
			
			//executing HQL Select Query as nested SQL query
			query=ses.createQuery("from Product  where price=(select max(price) from Product)");
			list=query.getResultList();
			list.forEach(p->{
				System.out.println(p);
			});
			

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close Session
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}// main
}// class
