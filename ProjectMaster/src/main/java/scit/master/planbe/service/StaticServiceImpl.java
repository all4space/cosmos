package scit.master.planbe.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.VO.UsersVO;
import scit.master.planbe.dao.StaticDAOImpl;


@Service
public class StaticServiceImpl implements StaticService{

	@Autowired
	StaticDAOImpl dao;

	@Override
	public ArrayList<ProjectVO> getProjectList(ArrayList<Integer> pnoList) {
		return dao.getProjectList(pnoList);
	}

	@Override
	public ArrayList<TaskVO> efficiency(ArrayList<Integer> pnoList) {
		ArrayList<TaskVO> task = dao.efficiency(pnoList);
		int totaltime = 0;
		int donetime = 0;
		int count = 0; // 프로젝트 별로 저장하기 위해 index 따로 생성

		for (TaskVO taskVO : task) {
			for (int i = 0; i < task.size(); i++) {
				if(i == 0 || task.get(i-1).getProjectNo() == task.get(i).getProjectNo()){
					totaltime += task.get(i).getTotalTime();
					donetime += task.get(i).getDoneTime();
				}else if(i+1 == task.size()){
					taskVO.setTotalTime(totaltime);
					taskVO.setDoneTime(donetime);
					task.set(count, taskVO);
				}else{
					taskVO.setTotalTime(totaltime);
					taskVO.setDoneTime(donetime);
					task.set(count, taskVO);
					totaltime = 0;
					donetime = 0;
					count += 1;
				}//else
			}//for
		}//foreach
		System.out.println(totaltime +"과"+donetime);
		System.out.println(task);
		return task;
	}

	@Override
	public ArrayList<TaskVO> progress(ProjectVO vo) {
		return dao.progress(vo);
	}

	@Override
	public ArrayList<UsersVO> taskOfusersName(ArrayList<Integer> memberNoList) {
		ArrayList<MemberVO> userNoList = dao.usernoGetMember(memberNoList);
		System.out.println("m"+userNoList);
		ArrayList<UsersVO> userNameList = dao.taskOfusersName(userNoList);
		System.out.println("u"+userNameList);
		for (MemberVO memberVO : userNoList) {
			for (UsersVO usersVO : userNameList) {
				if(usersVO.getUserNo() == memberVO.getUserNo()){
					usersVO.setUserNo(memberVO.getMemberNo());
				}
			}
		}
		System.out.println("re"+userNameList);
		return dao.taskOfusersName(dao.usernoGetMember(memberNoList));
	}
	
	


}
