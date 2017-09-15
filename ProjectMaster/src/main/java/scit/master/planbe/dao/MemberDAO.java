package scit.master.planbe.dao;

import java.util.ArrayList;

import scit.master.planbe.VO.MemberVO;

public interface MemberDAO 
{	    
	public void ManagerAdd(MemberVO memberVo);
	public void MemberAdd(MemberVO memberVo);
	public MemberVO getMemberNo(String userId);
	public ArrayList<Integer> getProjectNo(String userId);
}
