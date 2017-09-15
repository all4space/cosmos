package scit.master.planbe.service;

import java.util.ArrayList;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.TaskVO;

public interface PlanService {
	
 public void getPlan(); // 일정 달력 표시.
 
 public void updatePlan(); // 일정 달력 수정.
 
 public void deletePlan();// 일정 달력 삭제.
 
 public ArrayList<TaskVO>Day(TaskVO Task); // 일별 달력 표시.
 
 public ArrayList<TaskVO>Week(TaskVO Task); // 주별 달력 표시.
 
 public ArrayList<TaskVO>Month(TaskVO Task);// 월별 달력 표시.
 
 public ArrayList<TaskVO>Search(TaskVO Task); // 검색 표시.
 
 public ArrayList<TaskVO>Insert(TaskVO Task); // 일정 생성.
 
 public void DownLoad(TaskVO Task); // 다운로드.
 
 public ArrayList<MemberVO>ContactInfo();//컨텍드 표시. 

}
