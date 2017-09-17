package scit.master.planbe.controller;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.VO.TaskVO2;
import scit.master.planbe.VO.UsersVO;
import scit.master.planbe.service.StaticServiceImpl;

@RequestMapping("/static")
@Controller
public class StaticController {
	//안녕 소연아 열심히 해 화이팅
	
	@Autowired
	StaticServiceImpl service;
	
	// Static 페이지 불러오기 
	@RequestMapping(value = "staticForm", method = RequestMethod.GET)
	public String staticForm() {
		return "redirect:/member/getProjectNo";
	}
	
	// 업무 전체 효율
	@RequestMapping(value = "getProjectList", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,Object> efficiency(@RequestParam(value = "pnoList[]") ArrayList<Integer> pnoList) {
		ArrayList<ProjectVO> p_vo = service.getProjectList(pnoList);
		ArrayList<TaskVO> efficiencyTime = service.efficiency(pnoList);
		HashMap<String,Object> map = new HashMap<>();
		map.put("projectList", p_vo);
		map.put("taskList", efficiencyTime);
		return map;
	}
	
	// 업무 할당
	@RequestMapping(value = "getTaskList", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String,Object> progress(ProjectVO vo) {
		ArrayList<TaskVO> taskList = service.progress(vo); //TaskList
		
		ArrayList<Integer> memberNoList = new ArrayList<>(); // 랭킹 위한 이름
		for (TaskVO taskVO : taskList) {
			if(!memberNoList.contains(taskVO.getMemberNo())){
				memberNoList.add(taskVO.getMemberNo());
			}
		}
		
		ArrayList<UsersVO> usersNamelist = service.taskOfusersName(memberNoList);
		ArrayList<TaskVO2> taskandnameList = new ArrayList<>();
		for (TaskVO taskVO : taskList) {
			for (UsersVO usersVO : usersNamelist) {
				if(taskVO.getMemberNo() == usersVO.getUserNo()){
					TaskVO2 taskAndname = new TaskVO2(taskVO.getProjectNo(),
							taskVO.getMemberNo(),taskVO.getTaskNo(),
							taskVO.getTaskName(),usersVO.getUserName(),
							taskVO.getTotalTime(),taskVO.getDoneTime());
						taskandnameList.add(taskAndname);
				}
			}
		}
		
		System.out.println("ts2"+taskandnameList);
		HashMap<String,Object> map = new HashMap<>();
		map.put("taskList", taskList);
		map.put("usersNamelist", taskandnameList);
		return map;
	}
}
