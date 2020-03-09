package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

import lombok.Data;

@Data
@Entity
/*@NamedNativeQuery(name = "GET_PROJECTS_BY_TEAM_SIZE_RANGE",
                                           query = " SELECT  PROJID,PROJNAME,DOMAIN,COMPANY,TEAMSIZE  FROM  PROJECT WHERE TEAMSIZE>=:min AND TEAMSIZE<=:max",
                                           resultClass = Project.class)
@NamedNativeQuery(name = "STREAMLINE_TEAMSIZE",
                                          query = "UPDATE PROJECT SET TEAMSIZE=TEAMSIZE-:correction WHERE TEAMSIZE>=:size")

@NamedNativeQuery(name = "GET_PROJECTS_INFO_BY_DOMAIN_NAME",
                                            query = "SELECT PROJNAME,TEAMSIZE FROM PROJECT WHERE DOMAIN LIKE :dmn")*/

@NamedNativeQuery(name = "GET_PROJECTS_BY_TEAM_SIZE_RANGE",
query = " SELECT  PROJID,PROJNAME,DOMAIN,COMPANY,TEAMSIZE  FROM  PROJECT WHERE TEAMSIZE>=:min AND TEAMSIZE<=:max",
resultClass = Project.class)
/*@NamedNativeQuery(name = "STREAMLINE_TEAMSIZE",
query = "UPDATE PROJECT SET TEAMSIZE=TEAMSIZE-:correction WHERE TEAMSIZE>=:size")
*/
/*@NamedNativeQuery(name = "GET_PROJECTS_INFO_BY_DOMAIN_NAME",
 query = "SELECT PROJNAME,TEAMSIZE FROM PROJECT WHERE DOMAIN LIKE :dmn")*/

public class Project implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int projId;
	private String projName;
	private String domain;
	private  String company;
	private  int teamSize;

}
