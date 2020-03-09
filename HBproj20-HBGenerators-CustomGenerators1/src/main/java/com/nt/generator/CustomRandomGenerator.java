package com.nt.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomRandomGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		Random rad=null;
		int idVal=0;
		//generate Random number
		rad=new Random();
		idVal=rad.nextInt(10000);
		return idVal;
	}

}
