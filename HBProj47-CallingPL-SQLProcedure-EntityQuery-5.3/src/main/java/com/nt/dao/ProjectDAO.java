package com.nt.dao;

import java.util.List;

import com.nt.entity.Project;

public interface ProjectDAO {
	
	public   List<Project>   fetchProjectsByTeamSizeRanges(int startRange,int endRange);

}
