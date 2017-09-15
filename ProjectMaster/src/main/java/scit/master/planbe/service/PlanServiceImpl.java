package scit.master.planbe.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.dao.PlanDAOImpl;

@Service
public class PlanServiceImpl implements PlanService{

	@Autowired
	PlanDAOImpl dao;

	@Override
	public void getPlan() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePlan() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePlan() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TaskVO> Day(TaskVO Task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TaskVO> Week(TaskVO Task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TaskVO> Month(TaskVO Task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TaskVO> Search(TaskVO Task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TaskVO> Insert(TaskVO Task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DownLoad(TaskVO Task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<MemberVO> ContactInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	



