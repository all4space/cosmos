package scit.master.planbe.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.TaskVO;

public interface TaskService {

public ArrayList<TaskVO> getList(String searchtype,String searchword, int startRecord, int countPerPage);//업무 리스트 출력하기

public void updateTask(TaskVO taskVo);//업무 리스트 수정

public ArrayList<TaskVO> Day(TaskVO task);//일별 업무 리스트

public ArrayList<TaskVO> Week(TaskVO task);//주별 업무 리스트

public ArrayList<TaskVO> Month(TaskVO task);//월별 업무 리스트

public TaskVO Search(TaskVO taskVo);//업무  검색

public void Insert(TaskVO task);//업무생성.

public void DownLoad(TaskVO task);//다운로드.

public ArrayList<MemberVO>ContactInfo();//컨텍트 정보.

public void deleteTask(TaskVO taskVo);// 업무 삭제

public ArrayList<TaskVO>searchTask(String a, String b); // 키워드 검색하기

public int getTotalCount(String searchtype,String searchword); // 총 레코드 수 가져오기.

public void excelList(HttpServletResponse response, String searchtype, String searchword, int startRecord, int countPerPage); // 엑셀 다운로드 


	
	
}//TaskController


