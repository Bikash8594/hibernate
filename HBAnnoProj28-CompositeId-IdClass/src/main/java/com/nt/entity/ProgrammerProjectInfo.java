package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name="PROGRAMMER_PROJECT_INFO")
@Data
public class ProgrammerProjectInfo implements Serializable {
	@EmbeddedId
	private ProgrammerProjectId id;
	@Column(name="PRGMRNAME",length = 10)
	@Type(type="string")
	private String prgmrName;
	@Column(name="PROJNAME",length = 10)
	@Type(type="string")
	private  String projName;
	@Column(name="COMPANY",length = 10)
	@Type(type="string")
	private String company;
}
