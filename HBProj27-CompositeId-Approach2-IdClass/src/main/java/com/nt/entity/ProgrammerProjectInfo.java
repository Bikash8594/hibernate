package com.nt.entity;

import java.io.Serializable;


public class ProgrammerProjectInfo implements Serializable {
	private ProgrammerProjectId id;
	private String prgmrName;
	private  String projName;
	private String company;
	
	public ProgrammerProjectInfo() {
		System.out.println("ProgrammerProjectInfo:: 0-param constructor");
	}
	
	public ProgrammerProjectId getId() {
		return id;
	}

	public void setId(ProgrammerProjectId id) {
		this.id = id;
	}
	
	
	public String getPrgmrName() {
		return prgmrName;
	}
	public void setPrgmrName(String prgmrName) {
		this.prgmrName = prgmrName;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	

	@Override
	public String toString() {
		return "ProgrammerProjectInfo [id=" + id + ", prgmrName=" + prgmrName + ", projName=" + projName + ", company="
				+ company + "]";
	}

	
	
}
