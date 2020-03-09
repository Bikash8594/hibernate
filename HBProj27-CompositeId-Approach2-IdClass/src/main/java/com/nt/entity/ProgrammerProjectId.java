package com.nt.entity;

import java.io.Serializable;


public class ProgrammerProjectId implements Serializable {
	private int projId;
	private int prgmrId;
	
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	public int getPrgmrId() {
		return prgmrId;
	}
	public void setPrgmrId(int prgmrId) {
		this.prgmrId = prgmrId;
	}
	
	@Override
	public String toString() {
		return "ProgrammerProjectId [projId=" + projId + ", prgmrId=" + prgmrId + "]";
	}
	
	

}
