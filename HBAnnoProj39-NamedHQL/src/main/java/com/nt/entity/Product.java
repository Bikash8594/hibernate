package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PRODUCT")
/*@NamedQueries(value= {@NamedQuery(name="GET_ALL_PRODUCTS",query = "FROM Product"),
		                                          @NamedQuery(name="DELETE_PRODUCTS_BY_PRICE_RANGE",query = "DELETE  FROM Product WHERE price<=:range")
                                                  })*/
@NamedQuery(name="GET_ALL_PRODUCTS",query = "FROM Product")
@NamedQuery(name="DELETE_PRODUCTS_BY_PRICE_RANGE",query = "DELETE  FROM Product WHERE price<=:range")
public class Product implements Serializable {
	@Id
	@Column(name="PID",length = 10)
	@Type(type="int")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@Column(name="PNAME",length = 15)
	@Type(type="string")
	private String pname;
	
	@Column(name="PRICE",length = 5,precision = 2)
	@Type(type="float")
	private float price;
	
	@Column(name="QTY",length = 5,precision = 2)
	@Type(type="float")
	private  float qty;
	
	@Column(name="STATUS",length = 5)
	@Type(type="boolean")
	private boolean status;

	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getQty() {
		return qty;
	}
	public void setQty(float qty) {
		this.qty = qty;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + ", status=" + status+ "]";
	}
	
	

}
