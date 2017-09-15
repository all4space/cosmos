package scit.master.planbe.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.UsersVO;
import scit.master.planbe.dao.ProjectDAOImpl;
import scit.master.planbe.dao.UsersDAOImpl;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectDAOImpl dao;
	
	@Autowired
	UsersDAOImpl userDao;
	
	@Override
	public int projectAdd(ProjectVO projectVo) {
		
		return dao.projectAdd(projectVo);
		 
	}

	@Override
	public boolean projectModify(UsersVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int projectDelete(int projectNo) {
		return dao.projectDelete(projectNo);
	}

	@Override
	public ArrayList<ProjectVO> getProjectList(int userNo) {
		return dao.getProjectList(userNo);
	}

	public ArrayList<UsersVO> groupNameList() {

		return dao.groupNameList();
	}

	public ArrayList<UsersVO> groupMemberList(UsersVO uvo) {

		return dao.groupMemberList(uvo);
	}

	public ArrayList<UsersVO> groupManagerList(String groupName) {
		return dao.groupManagerList(groupName);
	}

	public int getProjectSeq() {
		return dao.getProjectSeq();
	}
	
	public ProjectVO getProjectInfo(int projectNo) {
		return dao.getProjectInfo(projectNo);
	}

	@Override
	public ProjectVO getProject(int projectNo) {
		return null;
	}

	public String getGroupName(String userId) {
		return dao.getGroupName(userId);
	}
	@Override
	public void projectUpdate(ProjectVO projectList) {
		dao.projectUpdate(projectList);
	}

}
