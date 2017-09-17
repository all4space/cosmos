package scit.master.planbe.dao;


import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.TaskVO;


@Repository
public class GanttDAOImpl implements GanttDAO {

	@Autowired
	SqlSession Sqlsession;

	@Override
	public ArrayList<TaskVO> getGantt(MemberVO m_vo) {
		GanttMapper mapper = Sqlsession.getMapper(GanttMapper.class);
		return mapper.getGantt(m_vo);
	}

	@Override
	public ArrayList<TaskVO> year(MemberVO m_vo) {
		GanttMapper mapper = Sqlsession.getMapper(GanttMapper.class);
		return mapper.year(m_vo);
	}
	
	@Override
	public ArrayList<TaskVO> month(MemberVO m_vo) {
		GanttMapper mapper = Sqlsession.getMapper(GanttMapper.class);
		return mapper.month(m_vo);
	}

}
