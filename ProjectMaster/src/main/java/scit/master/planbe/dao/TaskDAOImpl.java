package scit.master.planbe.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import scit.master.planbe.VO.TaskVO;

@Repository
public class TaskDAOImpl implements TaskDAO{
	
	@Autowired
	SqlSession Sqlsession;

	
	//업무 생성하기
	@Override
	public void Insert(TaskVO taskVo) {
		
		System.out.println(taskVo);
		Taskmapper mapper = Sqlsession.getMapper(Taskmapper.class);
		 mapper.Insert(taskVo);
				
	}

	// 업무 리스트 가져오기
	@Override
	public ArrayList<TaskVO> getList(String searchtype, String searchword, int startRecord, int countPerPage) {
		Taskmapper mapper = Sqlsession.getMapper(Taskmapper.class);
		RowBounds rb = new RowBounds(startRecord,countPerPage);
		Map<String, String>map=new HashMap<>();
		map.put("searchtype", searchtype);
		map.put("searchword", searchword);		
		return mapper.getList(map,rb);		
	}

	// 업무 찾기
	@Override
	public TaskVO findTask(TaskVO taskVo) {		
	Taskmapper mapper = Sqlsession.getMapper(Taskmapper.class);
		return mapper.findTask(taskVo);
	}

	// 업무 수정하기
	@Override
	public void updateTask(TaskVO taskVo) {
		Taskmapper mapper = Sqlsession.getMapper(Taskmapper.class);
		 mapper.updateTask(taskVo);		
		
	}
	
	//업무 삭제하기
	public void deleteTask(TaskVO taskVo) {
		// TODO Auto-generated method stub		
		Taskmapper mapper = Sqlsession.getMapper(Taskmapper.class);
		 mapper.deleteTask(taskVo);		
				
	}

	public int getTotalCount(String searchtype, String searchword) {
		Taskmapper mapper = Sqlsession.getMapper(Taskmapper.class);
		Map<String, String>map=new HashMap<>();
		map.put("searchtype", searchtype);
		map.put("searchword", searchword);		
		return mapper.getTotalCount(map);		
	}



}
