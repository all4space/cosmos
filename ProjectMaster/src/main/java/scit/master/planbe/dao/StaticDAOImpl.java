package scit.master.planbe.dao;


import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;


@Repository
public class StaticDAOImpl implements StaticDAO {

	@Autowired
	SqlSession Sqlsession;

	@Override
	public ArrayList<ProjectVO> getProjectList(ArrayList<Integer> pnoList) {
		StaticMapper mapper = Sqlsession.getMapper(StaticMapper.class);
		System.out.println(pnoList);
		return mapper.getProjectList(pnoList);  
	}

	@Override
	public ArrayList<TaskVO> efficiency(ArrayList<Integer> pnoList) {
		StaticMapper mapper = Sqlsession.getMapper(StaticMapper.class);
		return mapper.efficiency(pnoList);
	}  
	
	
	

}
