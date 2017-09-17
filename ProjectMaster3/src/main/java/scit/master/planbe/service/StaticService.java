package scit.master.planbe.service;

import java.util.ArrayList;

import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.VO.UsersVO;

public interface StaticService {

	public ArrayList<ProjectVO> getProjectList(ArrayList<Integer> pnoList);
	
	public ArrayList<TaskVO> efficiency(ArrayList<Integer> pnoList); // 프로젝트별 진행률
	
	public ArrayList<TaskVO> progress(ProjectVO vo); // 업무별 진행률
	
	public ArrayList<UsersVO> taskOfusersName(ArrayList<Integer> usersNoList);

}