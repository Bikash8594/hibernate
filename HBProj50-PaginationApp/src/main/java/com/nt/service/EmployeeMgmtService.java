package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	
	public  List<EmployeeDTO> fetchReportData(int pageNo ,int pageSize);
	public  int   fetchPagesCount(int pageSize);

}
