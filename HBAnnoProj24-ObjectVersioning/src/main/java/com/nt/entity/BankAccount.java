package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long acno;
	private String holderName;
	private String bankName;
	private  float balance;
	
	@Version
	@Column(name="VER_COUNT")
	private int operationsCount;

}
