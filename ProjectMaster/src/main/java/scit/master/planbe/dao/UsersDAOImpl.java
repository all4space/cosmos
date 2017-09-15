package scit.master.planbe.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import scit.master.planbe.VO.UsersVO;

@Repository
public class UsersDAOImpl implements UsersDAO{
	
	@Autowired
	SqlSession Sqlsession;
	
	@Override
	public void join(UsersVO vo) {
		UsersMapper mapper = Sqlsession.getMapper(UsersMapper.class);
		mapper.join(vo);
	}
	
	@Override
	public UsersVO idCheck(String userId) {
		UsersMapper mapper = Sqlsession.getMapper(UsersMapper.class);
		return mapper.idCheck(userId);
	}
	
	@Override
	public UsersVO ctoCheck(UsersVO vo) {
		UsersMapper mapper = Sqlsession.getMapper(UsersMapper.class);
		return mapper.ctoCheck(vo);
	}
	
	@Override
	public UsersVO login(UsersVO vo) {
		UsersMapper mapper = Sqlsession.getMapper(UsersMapper.class);
		return mapper.login(vo);
	}

	@Override
	public int delete(UsersVO vo) {
		UsersMapper mapper = Sqlsession.getMapper(UsersMapper.class);
		return mapper.delete(vo);
	}
	
public ArrayList<UsersVO> groupNameList() {
		
		UsersMapper mapper = Sqlsession.getMapper(UsersMapper.class);
		return mapper.groupNameList();
	}

public int getUserNo(String userId) {
		
		UsersMapper mapper = Sqlsession.getMapper(UsersMapper.class);
				return mapper.getUserNo(userId);
		
}

public ArrayList<UsersVO> getMemberList(int projectNo) {
	UsersMapper mapper = Sqlsession.getMapper(UsersMapper.class);
	return mapper.getMemberList(projectNo);

}
@Override
public ArrayList<UsersVO> getUserVo(String groupName) {
	UsersMapper mapper = Sqlsession.getMapper(UsersMapper.class);
	return mapper.getUserVo(groupName);
}
@Override
public UsersVO getUserInfo(int userNo) {
	UsersMapper mapper = Sqlsession.getMapper(UsersMapper.class);
	return mapper.getUserInfo(userNo);
	}

}


	




