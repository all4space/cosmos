package scit.master.planbe.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.service.StaticServiceImpl;

@RequestMapping("/static")
@Controller
public class StaticController {
	
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
	public ArrayList<ProjectVO> efficiency(@RequestParam(value = "pnoList[]") ArrayList<Integer> pnoList, Model model) {
		ArrayList<ProjectVO> p_vo = service.getProjectList(pnoList);
		/*ArrayList<TaskVO> efficiencyTime = service.efficiency(pnoList);*/
		model.addAttribute("p_vo", p_vo);
		/*model.addAttribute("e_time", efficiencyTime);*/
		return p_vo;
	}
	
	
}
