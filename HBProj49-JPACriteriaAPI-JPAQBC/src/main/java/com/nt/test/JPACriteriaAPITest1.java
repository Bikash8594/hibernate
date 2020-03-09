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

public class JPACriteriaAPITest1 {

	public static void main(String[] args) {
		  Session ses=null;
		  CriteriaBuilder builder=null;
		  CriteriaQuery<Employee> ctQuery=null;
		  Root <Employee> root=null;
		  Query query=null;
		  List<Employee> list=null;
		  ParameterExpression<Integer>  param1=null;
		  ParameterExpression<Integer>  param2=null;
		  Predicate  pdc1=null,pdc2=null, finalPdc=null;
		  Order order=null;
		  ParameterExpression<String>  param3=null,param4=null;
		  Predicate  pdc3=null,pdc4=null,finalOrPdc=null;
		 
		  
		  //get Session
		  ses=HibernateUtil.getSession();
		  try {
			/*	 //get CriteriaBuilder
				  builder=ses.getCriteriaBuilder();
				  //get CriteriaQuery object
				  ctQuery=builder.createQuery(Employee.class);
				  //create Root object
				  root=ctQuery.from(Employee.class);
				  ctQuery.select(root);
				  //prepare Query object having CriteriaQuery object
				  query=ses.createQuery(ctQuery);
				  //execute Query
				  list=query.getResultList();
				  list.forEach(emp->{
					  System.out.println(emp);
				  });*/
			  //JPA Criteria select operation with condition
			/*  //get CriteriaBuilder
			  builder=ses.getCriteriaBuilder();
			  //get CriteriaQuery object
			  ctQuery=builder.createQuery(Employee.class);
			  //create Root object
			  root=ctQuery.from(Employee.class);
			  ctQuery.select(root);
			  //create Parameters 
			  param1=builder.parameter(Integer.class);
			  param2=builder.parameter(Integer.class);
			  //create Predicate Objects
			  pdc1=builder.ge(root.get("eid"), param1);
			  pdc2=builder.le(root.get("eid"), param2);
			  finalPdc=builder.and(pdc1,pdc2);
			  //add condition
			  ctQuery.where(finalPdc);
			  //add Order
			  order=builder.desc(root.get("ename"));
			  ctQuery.orderBy(order);
			  //prepare Query object
			  query=ses.createQuery(ctQuery);
			  //set param values
			  query.setParameter(param1, 1000);
			  query.setParameter(param2, 2000);
			  //execute logic
			  list=query.getResultList();
			  //process the reuslt
			  list.forEach(emp->{
				  System.out.println(emp);
			  });*/
			  
			  //JPA Criteria select operation with condition
				  //get CriteriaBuilder
				  builder=ses.getCriteriaBuilder();
				  //get CriteriaQuery object
				  ctQuery=builder.createQuery(Employee.class);
				  //create Root object
				  root=ctQuery.from(Employee.class);
				  ctQuery.select(root);
				  //prepare Parmaeter
				  param3= builder.parameter(String.class);
				  param4= builder.parameter(String.class);
				  //create Predicate object
				  pdc3=builder.equal(root.get("eadd"),param3);
				  pdc4=builder.equal(root.get("eadd"),param4);
				  finalOrPdc=builder.or(pdc3,pdc4);
				  ctQuery.where(finalOrPdc);
				  //create Query object
				  query=ses.createQuery(ctQuery);
				  //set param values
				  query.setParameter(param3,"hyd");
				  query.setParameter(param4, "vizag");
				  //execute QBC
				  list=query.getResultList();
				  list.forEach(emp->{
					  System.out.println(emp);
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
