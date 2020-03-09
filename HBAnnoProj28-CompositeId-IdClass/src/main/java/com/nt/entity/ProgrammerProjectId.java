package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

import lombok.Data;


@Data
@Embeddable
public class ProgrammerProjectId implements Serializable {
	@Column(name="PROJID",length = 10)
	@Type(type="int")
	private int projId;
	@Column(name="PRGMRID",length = 10)
	@Type(type="int")
	private int prgmrId;
	
		
	

}
