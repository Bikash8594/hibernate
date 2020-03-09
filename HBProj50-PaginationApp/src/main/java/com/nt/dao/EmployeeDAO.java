package com.nt.dao;

import java.util.List;

import com.nt.entity.Employee;

public interface EmployeeDAO {
	
	public   long  getRecordsCount() ;
	public   List<Employee>  getReportData(int startPos,int pageSize);

}
