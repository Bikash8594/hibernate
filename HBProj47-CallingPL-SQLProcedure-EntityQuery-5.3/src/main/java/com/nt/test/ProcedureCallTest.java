package com.nt.test;

import java.util.List;

import com.nt.dao.ProjectDAO;
import com.nt.dao.ProjectDAOFactory;
import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class ProcedureCallTest {

	public static void main(String[] args) {
		ProjectDAO dao=null;
		List<Project> list=null;
		try {
		//get DAO
		dao=ProjectDAOFactory.getInstance();
		//invoke the method
		list=dao.fetchProjectsByTeamSizeRanges(10,20);
		//process the result
		list.forEach(proj->{
		   System.out.println(proj);
		});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
      finally {
    	  HibernateUtil.closeSessionFactory();
      }
		
		

	}

}
