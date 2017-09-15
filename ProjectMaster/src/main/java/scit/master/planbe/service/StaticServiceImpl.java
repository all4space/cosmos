package scit.master.planbe.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;
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
		return dao.efficiency(pnoList);
	}
	
	


}
