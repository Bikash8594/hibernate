package com.nt.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;


public class ProjectDAOImpl implements ProjectDAO {

	@Override
	public List<Project> fetchProjectsByTeamSizeRanges(int startRange, int endRange) {
		  Session ses=null;
		  ProcedureCall call=null;
		  Output output=null;
		  ResultSetOutput rsOutput=null;
		  List<Project> list=null;
         //get Session 
		  ses=HibernateUtil.getSession();
		  //create ProcedureCall object
		  call=ses.createStoredProcedureCall("P_GET_PROJECTS_BY_TEAMSIZE",Project.class);
		  //register IN,OUT params and set vlaues to IN params
		  call.registerParameter(1,Integer.class, ParameterMode.IN).bindValue(startRange);
		  call.registerParameter(2,Integer.class,ParameterMode.IN).bindValue(endRange);
		  call.registerParameter(3,Class.class,ParameterMode.REF_CURSOR);
		/*  //pagination
		  call.setFirstResult(0);
		  call.setMaxResults(3);*/
		  //call PL/SQL prcoedure
		  output=call.getOutputs().getCurrent();
		  //type casting
		  rsOutput=((ResultSetOutput)output);
		  
		  //convert output object to List<Project>
		  list=((ResultSetOutput)output).getResultList();
		  //close Session
		  HibernateUtil.closeSession(ses);
		return list;
	}

}
