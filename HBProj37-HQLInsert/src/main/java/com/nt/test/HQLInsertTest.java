package com.nt.test;

import com.nt.dao.TransferProductsDAO;
import com.nt.factory.TransferProductDAOFactory;
import com.nt.utility.HibernateUtil;

public class HQLInsertTest {

	public static void main(String[] args) {
		TransferProductsDAO  dao=null;
		int count=0;
		//get DAO
		dao=TransferProductDAOFactory.getInstance();
		//invoke method
		count=dao.transferProducts(10000,100000);
		System.out.println("No.of products that are transfered ::"+count);
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
