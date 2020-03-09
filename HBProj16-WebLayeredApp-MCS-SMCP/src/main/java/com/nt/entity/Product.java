package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product  implements Serializable {
	private int pid;
	private String pname;
	private float price;
	private  float qty;
	private  boolean status;
	private  int mid;

}
