package com.nt.entity;

import java.io.Serializable;


public class ProgrammerProjectInfo implements Serializable {
	private int prgmrId;
	private int projId;
	private String prgmrName;
	private  String projName;
	private String company;
	
	public ProgrammerProjectInfo() {
		System.out.println("ProgrammerProjectInfo:: 0-param constructor");
	}
	
	public int getPrgmrId() {
		return prgmrId;
	}
	public void setPrgmrId(int prgmrId) {
		this.prgmrId = prgmrId;
	}
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
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
		return "ProgrammerProjectInfo [prgmrId=" + prgmrId + ", projId=" + projId + ", prgmrName=" + prgmrName
				+ ", projName=" + projName + ", company=" + company + "]";
	}

	
}
