package com.nt.service;

import com.nt.dao.ManifacturerDAO;
import com.nt.dao.ManifacturerDAOImpl;
import com.nt.dao.ProductDAO;
import com.nt.dao.ProductDAOImpl;
import com.nt.dto.ManifacturerDTO;
import com.nt.dto.ProductDTO;
import com.nt.entity.Manifacturer;
import com.nt.entity.Product;

public class StoreMgmtServiceImpl implements StoreMgmtService {
     private ProductDAO  pDao=null;
     private ManifacturerDAO mDao=null;
     
	public StoreMgmtServiceImpl() {
		 pDao=new ProductDAOImpl();
		 mDao=new ManifacturerDAOImpl();
	}
	
	@Override
	public Object[] showCompleProductDetails(int pid) {
		Product  prod=null;
		Manifacturer manf=null;
		ProductDTO prodDTO=null;
		ManifacturerDTO manfDTO=null;
		//use daos and get entities
		prod=pDao.getProduct(pid);
		manf=mDao.getManifacturer(prod.getMid());
		//convert Entities to  DTOs
		prodDTO=new ProductDTO();
		prodDTO.setPid(prod.getPid());
		prodDTO.setPname(prod.getPname());
		prodDTO.setPrice(prod.getPrice());
		prodDTO.setQty(prod.getQty());
		prodDTO.setStatus(prod.isStatus());
		prodDTO.setMid(prod.getMid());
		
		manfDTO=new ManifacturerDTO();
		manfDTO.setMid(manf.getMid());
		manfDTO.setMname(manf.getMname());
		manfDTO.setGstNo(manf.getGstNo());
		manfDTO.setLocation(manf.getLocation());
		
		//return DTOs as Object[] to controller
		return new Object[] {prodDTO,manfDTO};
	}

}
