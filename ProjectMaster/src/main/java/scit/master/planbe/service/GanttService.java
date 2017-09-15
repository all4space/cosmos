package scit.master.planbe.service;

import java.util.ArrayList;

import scit.master.planbe.VO.HistoryVO;
import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.TaskVO;

public interface GanttService {
	//Gantt
	public ArrayList<TaskVO>getGantt(MemberVO m_vo);
	//히스토리 가져오기
	public ArrayList<HistoryVO> getHistoryList();
	public void historyAdd(HistoryVO vo); //히스토리 추가 (log 는 sysdate)
	
	public ArrayList<TaskVO> year(MemberVO m_vo);
	public ArrayList<TaskVO> month(MemberVO m_vo);
}
