package scit.master.planbe.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.dao.WbsDAOImpl;

@Service
public class WbsServiceImpl implements WbsService {

	@Autowired
	WbsDAOImpl dao;

	@Override
	public ArrayList<MemberVO> getMemberList(String userId) {
		return dao.getMemberList(userId);
	}

	@Override
	public ProjectVO getProjectInfo(int projectNo) {
		return dao.getProjectInfo(projectNo);
	}

	@Override
	public ArrayList<TaskVO> getTaskList(int projectNo) {
		return dao.getTaskList(projectNo);
	}
	
	@Override
	public String getMember(int memberNo) {
		return dao.getMember(memberNo);
	}
	
	@Override
	public boolean updateTask(TaskVO vo) {
		vo.setStartDate(vo.getStartDate().substring(0, 10)); 
		vo.setDueDate(vo.getDueDate().substring(0,10)); 
		if(dao.updateTask(vo) == 1) return true;	   
		return false;
	}
	
	@Override
	public boolean deleteTask(int taskNo) {
		if(dao.deleteTask(taskNo) == 1) return true;
		return false;
	}
	
}





	 
	


	



