package com.nt.entity;

import java.io.Serializable;

public class Employee implements Serializable {
	private int eid;
	private String ename;
	private String eadd;
	private Float esalary;
	private int age;
	
	public Employee() {
	   System.out.println("Employee:: 0-param constructor");
	}
	
	public int getEid() {
		System.out.println("Employee.getEid()");
		return eid;
	}
	public void setEid(int eid) {
		System.out.println("Employee.setEid()");
		this.eid = eid;
	}
	public String getEname() {
		System.out.println("Employee.getEname()");
		return ename;
	}
	public void setEname(String ename) {
		System.out.println("Employee.setEname()");
		this.ename = ename;
	}
	public String getEadd() {
		System.out.println("Employee.getEadd()");
		return eadd;
	}
	public void setEadd(String eadd) {
		System.out.println("Employee.setEadd()");
		this.eadd = eadd;
	}
	public Float getEsalary() {
		System.out.println("Employee.getEsalary()");
		return esalary;
	}
	public void setEsalary(Float esalary) {
		System.out.println("Employee.setEsalary()");
		this.esalary = esalary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}
