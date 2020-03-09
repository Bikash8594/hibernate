package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable
{
	private int eid;
	private String ename;
	private String eadd;
	private String edesg;
	private float esalary;

}
