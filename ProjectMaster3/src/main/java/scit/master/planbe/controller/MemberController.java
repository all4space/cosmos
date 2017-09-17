package scit.master.planbe.controller;


import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import scit.master.planbe.service.MemberServiceImpl;

@RequestMapping("/member")
@Controller
public class MemberController {
	
	@Autowired
	MemberServiceImpl service;
	
	@RequestMapping(value = "memberForm", method = RequestMethod.GET)
	public String memberForm() {
		return "memberForm";
	}
	
	@RequestMapping(value = "getProjectList", method = RequestMethod.GET) //로그인 유저의 멤버넘버를 가져온다.
	public ModelAndView getProjectList(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("loginId");
		HashMap<String,Object> map = service.getProjectList(userId);
		ModelAndView mav = new ModelAndView("/ganttForm");
		mav.addObject("member", map.get("member"));
		mav.addObject("project", map.get("project"));
		return mav;
	}
	
	@RequestMapping(value = "getProjectNo", method = RequestMethod.GET) //로그인 유저가 멤버로 속한 프로젝트 넘버를 가져온다.
	public String getProjectNo(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("loginId");
		model.addAttribute("projectNo_list", service.getProjectNo(userId)); 
		return "staticForm";
	}
}
