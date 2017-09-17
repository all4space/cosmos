package scit.master.planbe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.ProjectVO;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.service.WbsServiceImpl;

@RequestMapping("/wbs")
@Controller
public class WbsController {
	
	@Autowired
	WbsServiceImpl service;
	
	// Gantt와 연동 : Gantt 페이지에서 클릭한 프로젝트의 WBS 트리를 보여줌  
	@RequestMapping(value = "fromGantt", method = RequestMethod.GET)
	public String fromGantt(Model model, int projectNo) {
		model.addAttribute("fromG", projectNo);
		return "wbsForm";
	}
	
	// WBS 페이지 불러오기 
	@RequestMapping(value = "wbsForm", method = RequestMethod.GET)
	public String wbsForm(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("loginId");
		// MemberList 가져오기 (projectNo, authoriry 가져오기 위해)
		ArrayList<MemberVO> m_list = service.getMemberList(userId);
		
		// ProjectList 가져오기 
		ArrayList<ProjectVO> p_list = new ArrayList<>();
		for(MemberVO mvo : m_list){
			int projectNo = mvo.getProjectNo();
			p_list.add(service.getProjectInfo(projectNo));
		}
		
	    model.addAttribute("m_list", m_list);
		model.addAttribute("p_list", p_list);
		
		return "wbsForm";
	}
	
	// WBS 데이터 불러오기  
	@RequestMapping(value = "getWbs", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> getWbs(int projectNo) {
		// projectName 가져오기   
		ProjectVO vo = service.getProjectInfo(projectNo);

		// 프로젝트에 속한 TaskList 가져오기 
	    ArrayList<TaskVO> taskList = service.getTaskList(projectNo);
        
	    // TaskList의 각 Task 담당자(Member) 가져오기 
        ArrayList<String> memberList = new ArrayList<>();
        for(TaskVO t_vo : taskList){
        	int memberNo = t_vo.getMemberNo();
        	memberList.add(service.getMember(memberNo));
        }
        
	    HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("projectName", vo.getProjectName()); 
	    map.put("taskList", taskList);
	    map.put("memberList", memberList);
	    
	    return map;
	}
	    
	// WBS Update 1 : TaskInfo 수정 
	@RequestMapping(value = "updateTask")
	@ResponseBody
	public boolean updateTask(TaskVO vo) {
		if(service.updateTask(vo)) return true; 
		return false;
	}	
	    
	// WBS Update 2:  Task 삭제   
	@RequestMapping(value = "deleteTask", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteTask(int taskNo) {
		if(service.deleteTask(taskNo)) return true;
		return false;
	}
	
}
