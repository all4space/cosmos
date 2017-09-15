package scit.master.planbe.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value = "getMemberNo", method = RequestMethod.GET) //로그인 유저의 멤버넘버를 가져온다.
	public String getMemberNo(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("loginId");
		model.addAttribute("m_vo", service.getMemberNo(userId)); 
		return "ganttForm";
	}
	
	@RequestMapping(value = "getProjectNo", method = RequestMethod.GET) //로그인 유저가 멤버로 속한 프로젝트 넘버를 가져온다.
	public String getProjectNo(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("loginId");
		model.addAttribute("projectNo_list", service.getProjectNo(userId)); 
		return "staticForm";
	}
}
