package com.nt.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="BANKACCOUNT3")
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long acno;
	private String holderName;
	private String bankName;
	private  float balance;
	@CreationTimestamp
	private  LocalDateTime  openedOn;
	@UpdateTimestamp
	private  LocalDateTime  lastUpdated;
	@Version
	private  int  updationCount;


}
