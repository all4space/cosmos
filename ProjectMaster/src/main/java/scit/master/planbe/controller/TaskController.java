package scit.master.planbe.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import scit.master.planbe.VO.PageNavigator;
import scit.master.planbe.VO.TaskVO;
import scit.master.planbe.service.TaskService;

@RequestMapping("/task")
@Controller
public class TaskController {
	
	@Autowired
	TaskService task;
	
	//task.jsp로 이동
	@RequestMapping(value = "taskForm", method = RequestMethod.GET)
	public String taskmain(Model model, 
							@RequestParam(value="currentPage", defaultValue="1") int currentPage,
							@RequestParam(value="searchtype", defaultValue="title") String searchtype,
							@RequestParam(value="searchword", defaultValue="") String searchword) {
		
		int totalRecordCount=task.getTotalCount(searchtype, searchword);
		PageNavigator navi = new PageNavigator(currentPage, totalRecordCount, 5);
		model.addAttribute("taskList",task.getList(searchtype,searchword,navi.getStartRecord(),navi.getCountPerPage())); 
		model.addAttribute("result", navi);
		return "taskForm";				
	}
	
	//progress.jsp로 이동
	@RequestMapping(value = "progressForm", method = RequestMethod.GET)
	public String progressForm() {
		return "progress";
	}
	
	@ResponseBody
	@RequestMapping(value="getChart", method= RequestMethod.POST)
	public ArrayList<TaskVO> getList(String a, String b,
										@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		int totalRecordCount=task.getTotalCount(a, b);
		PageNavigator navi = new PageNavigator(currentPage, totalRecordCount, 5);
		System.out.println(task.getList(a,b,navi.getStartRecord(),navi.getCountPerPage()));
		return task.getList(a,b,navi.getStartRecord(),navi.getCountPerPage());
	}
	
	//newTask.jsp로 이동
	@RequestMapping(value = "newTaskForm", method = RequestMethod.GET)
	public String newTaskForm() {		
		return "newTask";
	}
	
	//새로운 업무 생성하기.
	@RequestMapping(value = "newTask", method = RequestMethod.POST)
	public String newTask(TaskVO taskVo,Model model) {		
		task.Insert(taskVo);		
		return "redirect:taskForm";
	}
	
	//updateTask.jsp로 이동
		@RequestMapping(value = "updateTaskForm", method = RequestMethod.GET)
		public String updateTaskForm(TaskVO taskVo,Model model) {			
			model.addAttribute("updateTask", task.Search(taskVo)); 
			System.out.println();
			return "updateTask";
		}
		
		//업무 수정하기
		@RequestMapping(value = "updateTask", method = RequestMethod.POST)
		public String updateTask(TaskVO taskVo,Model model) {
				task.updateTask(taskVo);
			return "redirect:taskForm";
		}
		
		//업무 삭제하기
		@RequestMapping(value = "deleteTask", method = RequestMethod.POST)
		public String deleteTask(TaskVO taskVo,Model model) {
				task.deleteTask(taskVo);
			return "redirect:taskForm";
		}
		
		//엑셀 다운로드
		@RequestMapping(value = "ExcelDownload", method = RequestMethod.GET)
		public String ExcelDownload(HttpServletResponse response,
									@RequestParam(value="currentPage", defaultValue="1") int currentPage,
									@RequestParam(value="searchtype", defaultValue="title") String searchtype,
									@RequestParam(value="searchword", defaultValue="") String searchword){
			int totalRecordCount=task.getTotalCount(searchtype, searchword);
			PageNavigator navi = new PageNavigator(currentPage, totalRecordCount, 5);			
				task.excelList(response,searchtype,searchword,navi.getStartRecord(),navi.getCountPerPage());
			return "taskForm";
		}
	
		
		
		
		
	
}

	

	
	
