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
	public boolean updateWbs(TaskVO vo) {
		vo.setStartDate(vo.getStartDate().substring(0, 10)); 
		vo.setDueDate(vo.getDueDate().substring(0,10)); 
		if(dao.updateWbs(vo) == 1) return true;	   
		return false;
	}
	
	@Override
	public boolean deleteTask(int taskNo) {
		if(dao.deleteTask(taskNo) == 1) return true;
		return false;
	}
	
	@Override
	public ArrayList<ProjectVO> getProjectList(String userId) {
	    return dao.getProjectList(userId);
	}
	
	@Override
	public ArrayList<MemberVO> getMemberList(String userId) {
		return dao.getMemberList(userId);
	}
	

	
	@Override
	public ArrayList<TaskVO> getTaskListByKey(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TaskVO> doneList(int projectNo, int key) {
		// 동일한 프로젝트에 속한 Task를 모두 불러온다. 
		ArrayList<TaskVO> t_list = dao.getTaskList(projectNo);
		// %DONE 에 해당하는 taskList만 담을 리스트를 생성한다.    
		ArrayList<TaskVO> taskList = new ArrayList<TaskVO>(); 
		
		// t_list 중에 유효 범위에 해당하는 Task만 선별한다. 
		for(int i=0; i<t_list.size(); i++){
			double doneTime = t_list.get(i).getDoneTime();
			double totalTime = t_list.get(i).getTotalTime();
			double rate = doneTime/totalTime;
			
			if((key <= rate*100) & (rate*100 < (key+20))){
				taskList.add(t_list.get(i));  
			}
		}
		return taskList;        		   
	}





}





	 
	


	



