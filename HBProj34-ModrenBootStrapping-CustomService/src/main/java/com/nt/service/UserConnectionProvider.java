package com.nt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;

public class UserConnectionProvider implements ConnectionProvider {

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
		Connection con=null;
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		return con;
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
