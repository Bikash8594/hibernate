package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class CriteriaAPITest {

	public static void main(String[] args) {
		  Session ses=null;
		  Criteria criteria=null;
		  List<Employee> list=null;
		  Criterion cond1=null,cond2=null,cond3=null,andCond=null,finalCond=null;
		  Order order=null;
		  Projection  p1=null,p2=null,p3=null;
		  ProjectionList pList=null;
		  List<Object[]> list1=null;
		  List<String> list2=null;
		  List<?> list3=null;
		  //get Session
		  ses=HibernateUtil.getSession();
		  try {
			/* //prepare Criteria object
			 criteria=ses.createCriteria(Employee.class);
			 //execute the Criteria logic
			 list=criteria.list();
			 //process the result
			 list.forEach(emp->{
			  System.out.println(emp);
			 });*/
			  
			/*  //create Criteria object
			  criteria=ses.createCriteria(Employee.class);
			  //create Criterion objects
			  cond1=Restrictions.between("eid",1, 5);
			  criteria.add(cond1);
			  //execute the QBC logic
			  list=criteria.list();
			  //process the Result
			  list.forEach(emp->{
				  System.out.println(emp);
			  });*/
			  
			/*  //create Criteria object
			  criteria=ses.createCriteria(Employee.class);
			  //create Criterion object
			  cond1=Restrictions.like("ename","a%");
			  //add condition
			  criteria.add(cond1);
			  //execute the QBC logic
			  list=criteria.list();
			  //process the Result
			  list.forEach(emp->{
				  System.out.println(emp);
			  });*/
			  
			/*	  //create Criteria object
				  criteria=ses.createCriteria(Employee.class);
				  //create Criterion objects
				  cond1=Restrictions.between("eid",1,5);
				  cond2=Restrictions.in("eadd","hyd","vizag");
				  cond3=Restrictions.ilike("ename","r%");
				  andCond=Restrictions.and(cond1,cond2);
				  finalCond=Restrictions.or(andCond,cond3);
				  //add final Condition
				  criteria.add(finalCond);
				  //execute QBC logic
				  list=criteria.list();
				  //process the Result
				  list.forEach(emp->{
					   System.out.println(emp);
				  });*/
			  
			/*    //create Criteria object
			  criteria=ses.createCriteria(Employee.class);
			  //cond1=Restrictions.sqlRestriction(" ename in('raja','anitha')");
			  //criteria.add(cond1);
			  criteria.setFirstResult(0);
			  criteria.setMaxResults(2);
			  list=criteria.list();
			  list.forEach(emp->{
				  System.out.println(emp);
			  });
			  */
			  
			/*	  //With Order , Criterion objects
				  criteria=ses.createCriteria(Employee.class);
				  //add Criterion objects
				  cond1=Restrictions.in("eadd","hyd","vizag");
				  criteria.add(cond1);
				  //add Order object
				  order=Order.desc("eadd");
				  criteria.addOrder(order);
				  //execute QBC logic
				  list=criteria.list();
				  //process the list
				  list.forEach(emp->{
					  System.out.println(emp);
				  });*/
			  
			  //workign with Projections to get Specific multiple col values
			/*	   //create Criteria object
				  criteria=ses.createCriteria(Employee.class);
				  //add Criterion object
				  cond1=Restrictions.eq("eadd","hyd");
				  criteria.add(cond1);
				  //prepare Projections
				  p1=Projections.property("eid");
				  p2=Projections.property("ename");
				  //add Projections to ProjectionList
				  pList=Projections.projectionList();
				  pList.add(p1); pList.add(p2);
				  //set ProjectionList to Criteria object
				  criteria.setProjection(pList);
				  //add Order object
				  order=Order.asc("ename");
				  criteria.addOrder(order);
				  //execute QBC 
				  list1=criteria.list();
				  //process the Result
				  list1.forEach(row->{
					  for(Object val:row) {
						  System.out.print(val+"   ");
					  }
					  System.out.println();
				  });*/
			  
			  //Working with Projections for getting single col values
			/*	       //create Criteria object
				    criteria=ses.createCriteria(Employee.class);
				    //prepare Projection object
				    p1=Projections.property("ename");
				    //set Projection obj to criteria object
				    criteria.setProjection(p1);
				    //execute QBC logic
				    list2=criteria.list();
				    //process the result
				    list2.forEach(name->{
				    	System.out.println(name);
				    });*/
			    
			/*//Working with Projections to get single aggregate result
			criteria=ses.createCriteria(Employee.class);
			//prepare Projection object
			p1=Projections.max("esalary");
			//set Projection obj to Criteria object
			criteria.setProjection(p1);
			//execute QBC
			list3=criteria.list();
			System.out.println("max salary is ::"+list3.get(0));*/
			  
			  //Working with Projections to get multiple aggregate results
			  criteria=ses.createCriteria(Employee.class);
			  //prepare Projection objs
			  p1=Projections.max("esalary");
			  p2=Projections.rowCount();
			  p3=Projections.avg("esalary");
			  //add to ProjectionList
			  pList=Projections.projectionList();
			  pList.add(p1); pList.add(p2); pList.add(p3);
			  //add to Criteria
			  criteria.setProjection(pList);
			  //execute QBC
			  list1=criteria.list();
			  //process the result
			  System.out.println("max sal is ::"+list1.get(0)[0]);
			  System.out.println("row count is ::"+list1.get(0)[1]);
			  System.out.println("avg salary is::"+list1.get(0)[2]);
			  
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
		  

	}

}
