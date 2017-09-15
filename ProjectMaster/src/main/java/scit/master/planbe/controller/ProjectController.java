package scit.master.planbe.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.UsersVO;
import scit.master.planbe.service.MemberServiceImpl;
import scit.master.planbe.service.ProjectServiceImpl;
import scit.master.planbe.service.UsersServiceImpl;

@RequestMapping("/project")
@Controller
public class ProjectController {
	
	@Autowired
	ProjectServiceImpl service;
	
	@Autowired
	UsersServiceImpl usersService;
	
	@Autowired
	MemberServiceImpl memberService;
	
	//프로젝트 삭제
	@RequestMapping(value = "projectDelete", method = RequestMethod.GET)
	public String projectDelete(int projectNo) {
		service.projectDelete(projectNo);
		return "redirect:projectList";	
	}
	
	@RequestMapping(value = "groupMemberList", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<UsersVO> groupMemberList(String userId) {
		UsersVO uvo = new UsersVO();
		String groupname = service.getGroupName(userId);
		uvo.setGroupName(groupname);
		uvo.setUserId(userId);
		return service.groupMemberList(uvo);
	}
	
	// group MemberList
	@RequestMapping(value = "projectForm", method = RequestMethod.GET)
	public ModelAndView projectForm(HttpSession session) {
		
		String groupname = service.getGroupName((String)session.getAttribute("loginId"));
		
		ModelAndView mov = new ModelAndView("/projectForm");
		mov.addObject("groupManagerList", service.groupManagerList(groupname));
		System.out.println("mov? " + mov.toString());
		
		return mov;
	}
	
	// PorjectList화면가기 전에 List 불러와야해
	@RequestMapping(value = "projectList", method = RequestMethod.GET)
	public ModelAndView projectList(HttpSession session)
	{
		String userId = (String) session.getAttribute("loginId");

		System.out.println(usersService.getUserNo(userId));
	
		ModelAndView mov = new ModelAndView("/projectList");
		mov.addObject("userNo",usersService.getUserNo(userId));
		mov.addObject("projectList", service.getProjectList(usersService.getUserNo(userId)));
		System.out.println("mov? " + mov.toString());
		
		return mov;
	}
	
	
	
	// group Member List 불러오기 ajax;
	/*@RequestMapping(value = "groupManagerList", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<UsersVO> groupManagerList(String groupName) {
		
		return service.groupManagerList(groupName);
	}*/
	
	@RequestMapping(value = "projectAdd", method = RequestMethod.POST)
	public ModelAndView projectAdd(HttpSession session, UsersVO userVo, 
			ProjectVO projectVo, MemberVO memberVo, String memberList, String managerId) throws ParseException {
		
		String userId = (String) session.getAttribute("loginId");
		projectVo.setUserNo(usersService.getUserNo(userId));

		/*String[] startDate = new String[3];
		String[] dueDate = new String[3];
		
		
		String start = projectVo.getStartDate();
		String due = projectVo.getDueDate();
		
		startDate = start.split("/");
		dueDate = due.split("/");

		start = startDate[2] + "/" + startDate[0] + "/" + startDate[1];
		due = dueDate[2] + "/" + dueDate[0] + "/" + dueDate[1];
		
		projectVo.setStartDate(start);
		projectVo.setDueDate(due);*/
	
		System.out.println(userVo.toString());
		System.out.println(memberVo.toString());
		System.out.println(projectVo.toString());
		
		
		System.out.println(managerId);
		System.out.println(memberList);
		service.projectAdd(projectVo); // 여기까지 프로젝트 생성
		
		
		// 지금부터 매니저에 떄려박을거양
		
		System.out.println(service.getProjectSeq());
		System.out.println(usersService.getUserNo(managerId));
		
		memberVo.setProjectNo(service.getProjectSeq());
		memberVo.setUserNo(usersService.getUserNo(managerId));

		SimpleDateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date start = stringFormat.parse(projectVo.getStartDate());
		Date due = dateFormat.parse(projectVo.getDueDate());
		
		long work = due.getTime() - start.getTime();
        long workDays = 8*(work / (24 * 60 * 60 * 1000));
        
        memberVo.setCanWork((int)workDays);
        memberVo.setMustWork((int)workDays);
        
        System.out.println(memberVo.toString());
        memberService.ManagerAdd(memberVo);
       
        
        String[] member = memberList.split(","); 
        
        for(int i = 0; i < member.length; i++)
		{
        	System.out.println(member[i]);
        	memberVo.setUserNo(
        	usersService.getUserNo(member[i]));
        	System.out.println(memberVo.toString());
        	
        	memberService.MemberAdd(memberVo);
		}
        
        
        System.out.println(projectVo.toString());
        
        ModelAndView mov = new ModelAndView("/newTaskForm");
		mov.addObject("MemberList", memberService.getMemberList(memberVo.getProjectNo()));
		System.out.println("mov? " + mov.toString());
		
		
		return mov;
	}
	
	@RequestMapping(value = "projectUpdateForm", method = RequestMethod.GET)
	public String projectUpdateForm(ProjectVO projectList, Model model) {
		
		ProjectVO list = service.getProjectInfo(projectList.getProjectNo());
		
		model.addAttribute("projectList",list);
		System.out.println(list.toString());
		
		return "projectUpdateForm";	
		
	}
	
	@RequestMapping(value = "projectUpdate", method = RequestMethod.POST)
	public String projectUpdate(ProjectVO projectList) {
		System.out.println("ProjectUpdate : " + projectList.toString());
		//날짜 짜르고
		projectList.setStartDate(projectList.getStartDate().substring(0, 10));
		projectList.setDueDate(projectList.getDueDate().substring(0, 10));

		service.projectUpdate(projectList);
		
		return "redirect:projectList";	
		
	}
	
	@RequestMapping(value = "projectInfo", method = RequestMethod.GET)
	public String projectInfo(ProjectVO pvo, Model model) {

	System.out.println(pvo.toString());
	int projectNo = pvo.getProjectNo();
	
	service.getProjectInfo(projectNo);

	model.addAttribute("pvo",service.getProjectInfo(projectNo));
	
	
		return "projectInfo";	
	}
}
	
	
	

