package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Manifacturer implements Serializable {
	private int mid;
	private String mname;
	private String location;
	private long gstNo;

}
