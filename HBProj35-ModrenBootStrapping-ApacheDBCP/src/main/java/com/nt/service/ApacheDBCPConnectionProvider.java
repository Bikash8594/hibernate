package com.nt.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;

public class ApacheDBCPConnectionProvider implements ConnectionProvider {

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("UserConnectionProvider.getConnection()");
		BasicDataSource ds=new BasicDataSource();
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("system"); ds.setPassword("manager");
		return ds.getConnection();
		
	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
		System.out.println("UserConnectionProvider.closeConnection()");
	conn.close();

	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
