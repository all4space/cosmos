package scit.master.planbe.dao;

import java.util.ArrayList;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.VO.UsersVO;

public interface ProjectMapper {
	
	public int projectAdd(ProjectVO projectVo);
	public int projectModify(UsersVO vo);
	public int projectDelete(int projectNo);
	public ProjectVO getProject(int projectNo);
	
	
	public MemberVO getMemberNo(UsersVO vo);
	/*Gantt 업무 그래프 : 시각화(일,주,달)는 컨트롤러에서 명령받을 것
	 **			서비스는 하나에서 일,주,달로 쪼개어 리턴함. 명령값(action) 받을거임
	 */
	public ArrayList<TaskVO> taskSerialize(MemberVO vo);

	public ArrayList<TaskVO> taskSerialize(MemberVO vo, String action);
	
	
	public ArrayList<UsersVO> groupNameList();
	public ArrayList<UsersVO> groupMemberList(UsersVO uvo);
	public ArrayList<UsersVO> groupManagerList(String groupName);
	public int getProjectSeq();
	public ArrayList<ProjectVO> getProjectList(int userNo);
	public ProjectVO getProjectInfo(int projectNo);
	public String getGroupName(String userId);
	public void projectUpdate(ProjectVO projectList);
}
