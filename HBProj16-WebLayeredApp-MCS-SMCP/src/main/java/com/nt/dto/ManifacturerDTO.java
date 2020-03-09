package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ManifacturerDTO implements Serializable {
	private int mid;
	private String mname;
	private String location;
	private long gstNo;

}
