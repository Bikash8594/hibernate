package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

@Entity
@Table(name="PAYMENT_INFO")
@DynamicInsert(value = true)
@Proxy(lazy = true,proxyClass = com.nt.entity.IPayment.class)
public final class Payment  implements IPayment {
	@Id
	//@Column(name="PAYID")
	@Column(length = 10)
	@Type(type="int")
	
	
	/*	  @GenericGenerator(name = "gen1",strategy = "increment")
		  @GeneratedValue(generator = "gen1")
	*/	  
	/* @GenericGenerator(name = "gen1",strategy = "identity")
	@GeneratedValue(generator ="gen1")*/
	
	/* @GenericGenerator(name = "gen1",strategy = "sequence")
		@GeneratedValue(generator ="gen1")*/
	
	/*	@GenericGenerator(name="gen2",strategy = "sequence",
		                                         parameters = {@Parameter(name="sequence_name", value = "Payid_seq")})
		@GeneratedValue(generator = "gen2")*/
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	/*@SequenceGenerator(name = "gen1",sequenceName = "PAYID_SEQ1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	*/
	/*@TableGenerator(name="gen1",table = "ID_GEN",pkColumnName = "PK_COL",pkColumnValue = "PAYID",valueColumnName = "VAL_COL",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.TABLE)*/
	/*@GeneratedValue(strategy = GenerationType.TABLE)*/
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payId;
	
	//@Column(name="AMOUNT")
	@Column(length=10)
	@Type(type="float")
	private float amount;
	
	//@Column(name="PAY_MODE")
	@Column(length=15)
	@Type(type="string")
	private String payMode;
	
	//@Column(name="VENDOR")
	@Column(length=15)
	@Type(type="string")
	private String vendor;
	
	public Payment() {
		System.out.println("Payment:: 0-param constructor");
	}
	
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", amount=" + amount + ", payMode=" + payMode + ", vendor=" + vendor + "]";
	}
	
	
	
	

}
