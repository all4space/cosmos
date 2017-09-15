package scit.master.planbe.dao;


import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import scit.master.planbe.VO.TaskVO;

public interface Taskmapper {
	public void Insert(TaskVO taskVo); // 업무 생성
	public ArrayList<TaskVO> getList(Map<String,String>map,RowBounds rb);//업무 리스트 출력하기
	public TaskVO findTask(TaskVO taskVo);// 업무 찾기
	public void updateTask(TaskVO taskVo); // 업무 수정하기
	public void deleteTask(TaskVO taskVo); // 업무 삭제하기
	public int getTotalCount(Map<String, String> map); // 총 레코드 수 가져오기
	

}

