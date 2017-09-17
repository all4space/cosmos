package scit.master.planbe.dao;

import java.util.ArrayList;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.VO.UsersVO;

public interface StaticMapper {
	       
	public ArrayList<ProjectVO> getProjectList(ArrayList<Integer> pnoList);

	public ArrayList<TaskVO> efficiency(ArrayList<Integer> pnoList);
	
	public ArrayList<TaskVO> progress(ProjectVO vo);
	
	public ArrayList<MemberVO> usernoGetMember(ArrayList<Integer> memberNoList); 
	
	public ArrayList<UsersVO> taskOfusersName(ArrayList<MemberVO> usersNoList);
	
	
}