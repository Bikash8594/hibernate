package com.nt.factory;

import com.nt.dao.TransferProductsDAO;
import com.nt.dao.TransferProductsDAOImpl;

public class TransferProductDAOFactory {
	
	public static  TransferProductsDAO getInstance() {
		 return  new TransferProductsDAOImpl();
	}

}
