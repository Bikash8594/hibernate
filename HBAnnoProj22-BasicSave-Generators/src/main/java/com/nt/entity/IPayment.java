package com.nt.entity;

public interface IPayment {
	
	public  int getPayId();
	public void  setPayId(int payId);
	public  float getAmount();
	public void  setAmount(float amount);
	public  String getVendor();
	public void  setVendor(String vendor);
	public  String getPayMode();
	public void  setPayMode(String paymode);
	
	

}
