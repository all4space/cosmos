package scit.master.planbe.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	// group Name List 불러오기
	@RequestMapping(value = "projectForm", method = RequestMethod.GET)
	public ModelAndView projectForm() {
		ModelAndView mov = new ModelAndView("/projectForm");
		mov.addObject("groupNameList", service.groupNameList());
		System.out.println("mov? " + mov.toString());
		
		return mov;
	}
	
	//ProjectNo에 맞는 project 정보 가져오기.
	@RequestMapping(value = "getProject", method = RequestMethod.POST)
	@ResponseBody
	public ProjectVO getProject(int projectNo) {
		return service.getProject(projectNo);
	}
	
	
	// group Member List 불러오기 ajax;
	@RequestMapping(value = "groupManagerList", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<UsersVO> groupManagerList(String groupName) {
		
		return service.groupManagerList(groupName);
	}
	@RequestMapping(value = "groupMemberList", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<UsersVO> groupMemberList(String groupName, String userId) {
		UsersVO uvo = new UsersVO();
		
		System.out.println(groupName); // 
		System.out.println(userId); // 매니저로 쓸거얌 그리고..얘빼고 다 뽑아낼거야 그룹에서
		
		uvo.setGroupName(groupName);
		uvo.setUserId(userId);
		
		return service.groupMemberList(uvo);
	}
		
		
	@RequestMapping(value = "projectAdd", method = RequestMethod.POST)
	public String projectAdd(HttpSession session, UsersVO userVo, 
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
        		
		return "taskFrom";
	}
	
		
}
