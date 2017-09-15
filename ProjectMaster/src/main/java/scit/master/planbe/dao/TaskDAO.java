package scit.master.planbe.dao;

import java.util.ArrayList;
import java.util.Map;

import scit.master.planbe.VO.TaskVO;

public interface TaskDAO {
	public void Insert(TaskVO taskVo); // 업무 생성
	public ArrayList<TaskVO> getList(String searchtype,String searchword,int startRecord, int countPerPage);//업무 리스트 출력하기
	public TaskVO findTask(TaskVO taskVo); // 업무 찾기
	public void updateTask(TaskVO taskVo); // 업무 수정하기
	public int getTotalCount(String searchtype,String searchword); // 총 레코드 수 가져오기

	
}

