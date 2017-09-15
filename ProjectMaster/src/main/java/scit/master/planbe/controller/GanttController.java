package scit.master.planbe.controller;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.service.GanttServiceImpl;

@RequestMapping("/gantt")
@Controller
public class GanttController {
	
	@Autowired
	GanttServiceImpl service;
	
	//1 Gantt 페이지 불러오기 
	@RequestMapping(value = "ganttForm", method = RequestMethod.GET)
	public String ganttForm() {
		return "redirect:/member/getMemberNo";
	}
	
	//2 Gantt 불러오기
	@RequestMapping(value = "getGantt", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<TaskVO> getGantt(MemberVO m_vo) {
		return service.getGantt(m_vo);
	}
	
	@RequestMapping(value = "year", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<TaskVO> year(MemberVO m_vo) {
		return service.year(m_vo);
	}
	
	@RequestMapping(value = "month", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<TaskVO> month(MemberVO m_vo) {
		return service.month(m_vo);
	}
}
