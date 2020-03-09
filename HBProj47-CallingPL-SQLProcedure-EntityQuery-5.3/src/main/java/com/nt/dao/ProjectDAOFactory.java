package com.nt.dao;

public class ProjectDAOFactory {
	
	public static ProjectDAO getInstance() {
		return new ProjectDAOImpl();
	}

}
