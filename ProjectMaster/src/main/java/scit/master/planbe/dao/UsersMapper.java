package scit.master.planbe.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import scit.master.planbe.VO.UsersVO;

public interface UsersMapper {
	public int join(UsersVO vo); // �쉶�썝 媛��엯
	public UsersVO idCheck(String userId); // ID 以묐났 泥댄겕 
	public UsersVO ctoCheck(UsersVO vo); // CTO 以묐났 泥댄겕 
	public UsersVO login(UsersVO vo); // 濡쒓렇�씤
	public int delete(UsersVO vo); // �쉶�썝 �깉�눜 
	public ArrayList<UsersVO> groupNameList();
	public int getUserNo(String userId);
}
