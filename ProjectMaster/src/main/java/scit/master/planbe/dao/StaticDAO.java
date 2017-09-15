package scit.master.planbe.dao;

import java.util.ArrayList;

import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;

public interface StaticDAO {
	    
	public ArrayList<ProjectVO> getProjectList(ArrayList<Integer> pnoList);
	
	public ArrayList<TaskVO> efficiency(ArrayList<Integer> pnoList);
}
