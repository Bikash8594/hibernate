package com.nt.entity;

public interface IInsurance {
	public void setPolicyId(int policyId);
	public void setPolicyName(String policyName);
	public void setCompany(String company);
	public void setPolicyType(String policyType);
	public void setTenure(float tenure);
	public   int getPolicyId();
	public String  getPolicyName();
	public String  getCompany();
	public String  getPolicyType();
	public float  getTenure();

}
