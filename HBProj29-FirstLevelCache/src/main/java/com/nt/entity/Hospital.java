package com.nt.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hospital  implements Serializable{
	private int hospitalId;
	private String hospitalName;
	private String addrs;
	private  long contactNo;
	private  int capacity;
	
	public Hospital() {
		System.out.println("Hospital::0-param constructor");
	}

	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", addrs=" + addrs
				+ ", contactNo=" + contactNo + ", capacity=" + capacity + "]";
	}
	
	

}
