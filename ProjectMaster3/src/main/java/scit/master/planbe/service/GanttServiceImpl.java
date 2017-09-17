package scit.master.planbe.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scit.master.planbe.VO.HistoryVO;
import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.dao.GanttDAOImpl;

@Service
public class GanttServiceImpl implements GanttService{

	@Autowired
	GanttDAOImpl dao;

	@Override
	public ArrayList<TaskVO> getGantt(MemberVO m_vo) { 
		return dao.getGantt(m_vo);	
	}
	
	@Override
	public ArrayList<HistoryVO> getHistoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void historyAdd(HistoryVO vo) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<TaskVO> year(MemberVO m_vo) {
		return dao.year(m_vo);
	}

	@Override
	public ArrayList<TaskVO> month(MemberVO m_vo) {
		return dao.month(m_vo);
	}

}
