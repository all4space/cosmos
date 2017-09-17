package scit.master.planbe.dao;

import java.util.ArrayList;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.ProjectVO;

public interface MemberDAO 
{	    
	public void ManagerAdd(MemberVO memberVo);
	public void MemberAdd(MemberVO memberVo);
	public ArrayList<MemberVO> getMyProject(String userId);
	public ArrayList<ProjectVO> getProjectInfo(ArrayList<Integer> projectNo);
	public ArrayList<Integer> getProjectNo(String userId);
}
