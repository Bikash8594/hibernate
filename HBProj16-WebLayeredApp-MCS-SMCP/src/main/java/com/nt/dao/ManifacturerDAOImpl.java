package com.nt.dao;

import org.hibernate.Session;

import com.nt.entity.Manifacturer;
import com.nt.utility.HibernateUtil;

public class ManifacturerDAOImpl implements ManifacturerDAO {

	@Override
	public Manifacturer getManifacturer(int mid) {
		Session ses=null;
		Manifacturer manf=null;
		//get Session obj
		ses=HibernateUtil.getSession();
		System.out.println("ManifacturerDAOImpl.getManifacturer():: ses hashCode::"+ses.hashCode());
		//Load object
		manf=ses.get(Manifacturer.class, mid);
		return manf;
	}

}
