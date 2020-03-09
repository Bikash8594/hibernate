package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Project implements Serializable {
	private  int projId;
	private String projName;
	private String domain;
	private  String company;
	private  int teamSize;

}
