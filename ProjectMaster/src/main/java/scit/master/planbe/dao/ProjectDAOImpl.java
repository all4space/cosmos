package scit.master.planbe.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.VO.UsersVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int projectAdd(ProjectVO projectVo) {
		ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
		return mapper.projectAdd(projectVo);
	}

	@Override
	public int projectModify(UsersVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int projectDelete(int projectNo) {
		ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
		return mapper.projectDelete(projectNo);
		
	}

	@Override
	public ProjectVO getProject(int projectNo) {
		ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
		return mapper.getProject(projectNo);
	}

	@Override
	public MemberVO getMemberNo(UsersVO vo) {
		ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
		return mapper.getMemberNo(vo);
	}

	@Override
	public ArrayList<TaskVO> taskSerialize(MemberVO vo) {
		ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
		return mapper.taskSerialize(vo);
	}

	public ArrayList<UsersVO> groupNameList() {
		
		ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
		return mapper.groupNameList();
	}

	public ArrayList<UsersVO> groupMemberList(UsersVO uvo) {
		ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
		return mapper.groupMemberList(uvo);
	}

	public ArrayList<UsersVO> groupManagerList(String groupName) {
		ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
		return mapper.groupManagerList(groupName);
	}

	public int getProjectSeq() {
		ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
		return mapper.getProjectSeq();
	}

		@Override
		public ArrayList<ProjectVO> getProjectList(int userNo) {
			ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
			return mapper.getProjectList(userNo);
		}

		public ProjectVO getProjectInfo(int projectNo) {
			ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
			return mapper.getProjectInfo(projectNo);
		}

		public String getGroupName(String userId) {
			ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
			return mapper.getGroupName(userId);
		}
		@Override
		public void projectUpdate(ProjectVO projectList) {
			ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
			mapper.projectUpdate(projectList);
		}


}
