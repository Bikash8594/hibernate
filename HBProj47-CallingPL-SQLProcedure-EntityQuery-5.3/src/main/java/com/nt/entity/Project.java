package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Project implements Serializable {
	@Id
	private int projId;
	private String projName;
	private String domain;
	private  String company;
	private  int teamSize;

}
