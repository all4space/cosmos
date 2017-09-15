package scit.master.planbe.service;

import java.util.ArrayList;

import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.UsersVO;

public interface ProjectService { //생성
	
	public int projectAdd(ProjectVO projectVo);
	public boolean projectModify(UsersVO vo);
	public ProjectVO getProject(int projectNo);// projectNo와 일치하는 project 정보 가져오기
	public ArrayList<ProjectVO> getProjectList(int userNo);
	public int projectDelete(int projectNo); // 프로젝트 삭제
	public void projectUpdate(ProjectVO projectList);
}
