package scit.master.planbe.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.UsersVO;
import scit.master.planbe.service.ProjectService;
import scit.master.planbe.service.ProjectServiceImpl;
import scit.master.planbe.service.UsersServiceImpl;

@RequestMapping("/users")
@Controller
public class UsersController {
	
	@Autowired
	UsersServiceImpl service;
	
	@Autowired
	ProjectServiceImpl projectService;
	
	// 로그인 양식 불러오기 
	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	 
	// 로그인 
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UsersVO vo, HttpSession session) {
		service.login(vo, session);
		return "redirect:/";
	}
	
	// 회원 가입 양식 불러오기 
	@RequestMapping(value = "joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "joinForm";
	}
	
	// 회원 가입
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(UsersVO vo) {
		service.join(vo);
		return "redirect:/";
	}
	
	// ID 중복 체크 
	@RequestMapping(value = "idCheck", method = RequestMethod.POST)
	@ResponseBody
	public boolean idCheck(String userId) {
        return service.idCheck(userId);
	}
	
	// CTO 중복 체크 
	@RequestMapping(value = "ctoCheck", method = RequestMethod.POST)
	@ResponseBody
	public boolean ctoCheck(UsersVO vo) {
	    return service.ctoCheck(vo);
	}
	
	// 로그아웃
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
        session.invalidate();
		return "redirect:/";
	}
     
	// 회원 탈퇴 양식 불러오기
	@RequestMapping(value = "deleteForm", method = RequestMethod.GET)
	public String deleteForm() {
		return "deleteForm";
	}
	
	// 회원 탈퇴
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(UsersVO vo, RedirectAttributes rttr) {
        if(service.delete(vo)){
        	rttr.addFlashAttribute("msg", "true");
        }
        else{
        	rttr.addFlashAttribute("msg", "false");
        }
        return "redirect:/";
	}
	//유저 정보 페이지로 이동
	
	@RequestMapping(value = "userInfoForm", method = RequestMethod.GET)
	public String userInfo(int userNo, Model model)
	{
		
		model.addAttribute("userVo", service.getUserInfo(userNo));
		
		
		return "userInfoForm";
	}
	// 유저넘버로 프로젝트 ㅍ불러옴
	@RequestMapping(value = "projectList", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<ProjectVO> projectList(int userNo)
	{
		return projectService.getProjectList(userNo);
	}
}
