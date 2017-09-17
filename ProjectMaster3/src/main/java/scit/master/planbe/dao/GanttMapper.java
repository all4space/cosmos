package scit.master.planbe.dao;

import java.util.ArrayList;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.VO.UsersVO;

public interface GanttMapper {
	       
	public ArrayList<TaskVO> getGantt(MemberVO m_vo);
	
	public ArrayList<ProjectVO> getProjectList(UsersVO u_vo);

	public ArrayList<TaskVO> year(MemberVO m_vo);
	public ArrayList<TaskVO> month(MemberVO m_vo);
}