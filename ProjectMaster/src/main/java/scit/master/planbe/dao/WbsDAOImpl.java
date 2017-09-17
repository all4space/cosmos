package scit.master.planbe.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;

@Repository
public class WbsDAOImpl implements WbsDAO {

	@Autowired
	SqlSession Sqlsession;  
	
	@Override
	public ArrayList<MemberVO> getMemberList(String userId) {
		WbsMapper mapper = Sqlsession.getMapper(WbsMapper.class);
		return mapper.getMemberList(userId);
	}

	@Override
	public ProjectVO getProjectInfo(int projectNo) {
		WbsMapper mapper = Sqlsession.getMapper(WbsMapper.class);
		return mapper.getProjectInfo(projectNo);
	}
	
	@Override
	public ArrayList<TaskVO> getTaskList(int projectNo) {
		WbsMapper mapper = Sqlsession.getMapper(WbsMapper.class);
		return mapper.getTaskList(projectNo);
	}

	@Override
	public String getMember(int memberNo) {
		WbsMapper mapper = Sqlsession.getMapper(WbsMapper.class);
		return mapper.getMember(memberNo);
	}

	@Override
	public int updateTask(TaskVO vo) {
		WbsMapper mapper = Sqlsession.getMapper(WbsMapper.class);
		return mapper.updateTask(vo);
	}

	@Override
	public int deleteTask(int taskNo) {
		WbsMapper mapper = Sqlsession.getMapper(WbsMapper.class);
		return mapper.deleteTask(taskNo);
	}
	
}





	
