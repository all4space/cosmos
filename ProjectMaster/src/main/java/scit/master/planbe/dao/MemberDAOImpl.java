package scit.master.planbe.dao;


import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import scit.master.planbe.VO.MemberVO;


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
	public MemberVO getMemberNo(String userId) {
		MemberMapper mapper = Sqlsession.getMapper(MemberMapper.class);
		return mapper.getMemberNo(userId);
	}

	@Override
	public ArrayList<Integer> getProjectNo(String userId) {
		MemberMapper mapper = Sqlsession.getMapper(MemberMapper.class);
		return mapper.getProjectNo(userId);
	}  
}
