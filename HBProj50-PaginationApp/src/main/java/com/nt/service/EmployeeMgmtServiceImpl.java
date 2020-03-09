package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	 private EmployeeDAO dao;
	public    EmployeeMgmtServiceImpl() {
		 dao=new EmployeeDAOImpl();
	}

	@Override
	public List<EmployeeDTO> fetchReportData(int pageNo, int pageSize) {
		int startPos=0;
		List<Employee> listEntities=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		
		//get Start Position
		startPos=(pageNo*pageSize)-pageSize;
		//use dAO
		listEntities=dao.getReportData(startPos, pageSize);
		//convert listEntities to listDTOs
		listEntities.forEach(entity->{
			EmployeeDTO  dto=new EmployeeDTO();
			dto.setEid(entity.getEid());
			dto.setEname(entity.getEname());
			dto.setEdesg(entity.getEdesg());
			dto.setEsalary(entity.getEsalary());
			dto.setEadd(entity.getEadd());
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public int fetchPagesCount(int pageSize) {
		long totalRecords=0;
		int pagesCount=0;
		//use dAO
		totalRecords=dao.getRecordsCount();
		//get pagesCount
		pagesCount=(int) (totalRecords/pageSize);
		if(totalRecords%pageSize!=0)
			pagesCount++;
		
		return pagesCount ;
	}

}
