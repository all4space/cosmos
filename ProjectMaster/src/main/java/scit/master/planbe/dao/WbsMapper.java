package scit.master.planbe.dao;

import java.util.ArrayList;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;

public interface WbsMapper {
	       
	// MemberList 가져오기 : projectNo, authoriry 가져오기 위해
	public ArrayList<MemberVO> getMemberList(String userId);

	// Project 정보 가져오기 : 하나의 Project의 정보를 가져오는 메소드.  
	public ProjectVO getProjectInfo(int projectNo); 

	// TaskList 가져오기 : 동일한 프로젝트에 속한 Task들을 전부 가져오는 메소드. 
	public ArrayList<TaskVO> getTaskList(int projectNo); 
	
	// TaskList의 각 Task 담당자(Member) 가져오기 
	public String getMember(int memberNo);

	// TaskInfo 수정하기 	
	public int updateTask(TaskVO vo);
	
	// Task 삭제하기 
	public int deleteTask(int taskNo);

}