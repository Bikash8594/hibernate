package com.nt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public long getRecordsCount() {
		Session ses=null;
		Criteria criteria=null;
		Projection p1=null;
		List<Object> list=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create dummy tx
		tx=ses.beginTransaction();
		//create Criteria object
		criteria=ses.createCriteria(Employee.class);
		//add Projection
		p1=Projections.rowCount();
		criteria.setProjection(p1);
		//execute QBC
		list=criteria.list();
		tx.commit();
		return (Long)list.get(0);
	}

	@Override
	public List<Employee> getReportData(int startPos, int pageSize) {
		Session ses=null;
		Criteria criteria=null;
		List<Employee> list=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create dummy Tx
		tx=ses.beginTransaction();
		//create Criteria object
		criteria=ses.createCriteria(Employee.class);
		//set pagination params
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(pageSize);
		//execute QBC
				list=criteria.list();
		tx.commit();
		return list;
	}

}
