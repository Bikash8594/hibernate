package com.nt.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="BANKACCOUNT2")
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long acno;
	private String holderName;
	private String bankName;
	private  float balance;
	@CreationTimestamp
	private  Timestamp  openedOn;
	@UpdateTimestamp
	private  Timestamp  lastUpdated;


}
