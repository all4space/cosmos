package scit.master.planbe.dao;


import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.ProjectVO;


@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SqlSession Sqlsession;

	@Override
	public void ManagerAdd(MemberVO memberVo) {
		MemberMapper mapper = Sqlsession.getMapper(MemberMapper.class);
		mapper.ManagerAdd(memberVo);
	}
	
	@Override
	public void MemberAdd(MemberVO memberVo) {
		MemberMapper mapper = Sqlsession.getMapper(MemberMapper.class);
		mapper.MemberAdd(memberVo);	
	}  
	
	@Override
	public ArrayList<MemberVO> getMyProject(String userId) {
		MemberMapper mapper = Sqlsession.getMapper(MemberMapper.class);
		return mapper.getMyProject(userId);
	}  
	
	@Override
	public ArrayList<ProjectVO> getProjectInfo(ArrayList<Integer> projectNo) {
		StaticMapper mapper = Sqlsession.getMapper(StaticMapper.class);
		return mapper.getProjectList(projectNo);
	}

	@Override
	public ArrayList<Integer> getProjectNo(String userId) {
		MemberMapper mapper = Sqlsession.getMapper(MemberMapper.class);
		return mapper.getProjectNo(userId);
	}
}
