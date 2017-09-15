package scit.master.planbe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import scit.master.planbe.service.PlanServiceImpl;

@RequestMapping("/plan")
@Controller
public class PlanController {
	
	@Autowired
	PlanServiceImpl service;
	
	// Plan 페이지 불러오기 
	@RequestMapping(value = "planForm", method = RequestMethod.GET)
	public String planForm() {
		return "planForm";
	}
	
	
}
