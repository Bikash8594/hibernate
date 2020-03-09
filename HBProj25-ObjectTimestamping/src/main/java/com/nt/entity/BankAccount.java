package com.nt.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BankAccount {
	private long acno;
	private String holderName;
	private String bankName;
	private  float balance;
	private  Timestamp  lastUpdated;


}
