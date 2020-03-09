package com.nt.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class JPACriteriaAPITest2 {

	public static void main(String[] args) {
		  Session ses=null;
		  CriteriaBuilder builder=null;
		  CriteriaQuery<Object[]> ctQuery=null;
		  CriteriaQuery<Object> ctQuery1=null;
		  Root <Employee> root=null;
		  Query query=null;
		  ParameterExpression<String> param1=null;
		  Predicate  pdc1=null;
		  Order order=null;
		  List<Object[]> list=null;
		  List<Object> list1=null;
		  
		  //get Session
		  ses=HibernateUtil.getSession();
		  try {
			/*  //Getting specific mutiple col values..	
			   //get CriteriaBuilder
				  builder=ses.getCriteriaBuilder();
				  //get CriteriaQuery object
				  ctQuery=builder.createQuery(Object[].class);
				  //create Root object
				  root=ctQuery.from(Employee.class);
				  //sepcify specific multiple  properties/cols 
				  ctQuery.multiselect(root.get("eid"),root.get("eadd"));
				  //prepare Parameter
				  param1=builder.parameter(String.class);
				  //create Predicate
				  pdc1=builder.like(root.get("ename"),param1);
				  ctQuery.where(pdc1);
				  //add Order object
				  order=builder.desc(root.get("ename"));
				  ctQuery.orderBy(order);
				  //prepare Query object
				  query=ses.createQuery(ctQuery);
				  //set param values
				  query.setParameter(param1,"r%");
				  //execuate logic
				  list=query.getResultList();
				  //process the reuslts
				  list.forEach(row->{
					  for(Object val:row) {
						  System.out.print(val+" ");
					  }//for
					  System.out.println();
				  });//for
				  
			*/	
			//Getting specific mutiple col values..	
			/* //get CriteriaBuilder
			  builder=ses.getCriteriaBuilder();
			  //get CriteriaQuery object
			  ctQuery1=builder.createQuery(Object.class);
			  //create Root object
			  root=ctQuery1.from(Employee.class);
			  //get Aggreate results
			  ctQuery1.multiselect(builder.count(root.get("eid")));
			  //prepare Query object
			  query=ses.createQuery(ctQuery1);
			  //execute logic
			  list1=query.getResultList();
			  System.out.println("count::"+list1.get(0));*/
						 
				//Getting specific single col value
			  //get CriteriaBuilder
			  builder=ses.getCriteriaBuilder();
			  //get CriteriaQuery object
			  ctQuery1=builder.createQuery(Object.class);
			  //create Root object
			  root=ctQuery1.from(Employee.class);
			  ctQuery1.multiselect(root.get("ename"));
			  //prepare param
			  param1=builder.parameter(String.class);
			  //create Predicate object
			  pdc1=builder.equal(root.get("eadd"), param1);
			  ctQuery1.where(pdc1);
			  //prepare query object
			  query=ses.createQuery(ctQuery1);
			  //set param values
			  query.setParameter(param1,"hyd");
			  //execute logic
			  list1=query.getResultList();
			  //process the results
			  list1.forEach(name->{
				  System.out.println(name);
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
		  }
		  

	}//main
}//class
