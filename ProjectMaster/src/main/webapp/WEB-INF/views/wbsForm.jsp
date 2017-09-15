<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>WBS</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: CSS -->
	<link id="bootstrap-style" href="/planbe/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="/planbe/resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="/planbe/resources/bootstrap/css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="/planbe/resources/bootstrap/css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	<!-- end: CSS -->
	

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="/planbe/resources/bootstrap/css/ie.css" rel="stylesheet">
	<![endif]-->
	
	<!--[if IE 9]>
		<link id="ie9style" href="/planbe/resources/bootstrap/css/ie9.css" rel="stylesheet">
	<![endif]-->
		
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="/planbe/resources/bootstrap/img/favicon.ico">
	<!-- end: Favicon -->
		
<script src="/planbe/resources/js/jquery-3.2.1.min.js"></script>	
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>		
</head>

<script>

/* Gantt와 연동 */
/* 
    var projectNo = ${fromG} 
		$(function(projectNo){
		    if(projectNo != null) getWbs(projectNo);
		});

 */	


/* start : WBS 트리 생성 */

google.charts.load('current', {packages:['wordtree']});
google.charts.setOnLoadCallback(drawSimpleNodeChart);

 var wordtree;
 var nodeListData;
 var taskList;
 var memberList;
 var options;
 var proname;
 
 var jj; 
 var array2;
 
function drawSimpleNodeChart(p_name, t_list, m_list) {
    
	proname = p_name;
	taskList = t_list; 
	memberList = m_list;
	
	nodeListData = new google.visualization.arrayToDataTable([
    ['id', 'childLabel', 'parent', 'size', { role: 'style' }],

/* [1] Project 이름 : 최상위 parent 노드 */    
    
    [0, p_name, -1, 1, '#119455']
    
    ]);
	
/* [2] Task 이름 : 1단계 child 노드  */
	

    $(t_list).each(function(index, item) {  
    	nodeListData.addRow([index+1, item.taskName, 0, 1, '#3c43a7']);
    });// for each 


/* [3] Task 키워드 : 2단계 child 노드 */    

	var x = t_list.length; ///
    var keyword = ['Member', 'Content', 'Priority', 'Status', 'Start Date', 'Due Date', 'Total Time', 'Done Time'];
	var y = keyword.length; // 8
    /* 3단계 child 노드의 parent id를 담을 배열 선언 */
	var xx = [];
    /* 3단계 child 노드의 id 선언 및 초기화 */
    var j = x+(x*y); // 80 
     
    var init = x;
    
    jj = j;
    
    $(t_list).each(function(index, item) {  
          var z = 0;
          for(var i = init+1; i < init+y+1; i++){
	   		     nodeListData.addRow([i, keyword[z], index+1, 1, '#b082f9']);
	   		     xx.push(i);
	             z += 1;
	      }
	   	  init += y;
     });// for each
          
	// alert(JSON.stringify(xx));
     
	
/* [4] Task 키워드의 각 컨텐츠 : 3단계 child 노드 */         

    /* 3단계 child 노드의 value를 담을 배열 선언 */
    var array = [];
//    var due = [];

    array2 = array;

    $(t_list).each(function(index, item) {  
    	 array.push(m_list[index]);
    	 array.push(item.taskContent);
         array.push(item.taskPriority);
         array.push(item.taskStatus);
         array.push(item.startDate);
         array.push(item.dueDate);
//       due.push(item.dueDate.substr(0, 10));
         array.push(item.totalTime.toString());
         array.push(item.doneTime.toString());
         
    });// for each
    

    /* sysdate : 보류 */    
/*  
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();

    if(dd<10) {
        dd = '0'+dd
    } 

    if(mm<10) {
        mm = '0'+mm
    } 

    today = yyyy + '-' + mm + '-' + dd;
*/
    
  	for(var i = 0, q = j+1; i < array.length; i++, q++){
  		 nodeListData.addRow([q, array[i], xx[i], 1, '#a4b83c']);
	  	   /* 우선순위가 HIGH인 노드의 color는 red로 변경한다 */
  		   if(nodeListData.getValue(q, 1) == 'HIGH'){
	  	     	nodeListData.setValue(q, 4, 'red');
	  	   }
	  	   
  	}
  	
    options = {
	    colors: ['black', 'black', 'black'],
	    wordtree: {
	      format: 'explicit',
	      type: 'suffix'
	    }
    };
    
  
  wordtree = new google.visualization.WordTree(document.getElementById('wordtree_explicit'));
  wordtree.draw(nodeListData, options);  // draw 
  
  //  $("text[text-anchor='start']").attr("text-anchor", "zero");
  /* 
	$("text[text-anchor='start']").on('click', function(){
		alert("click!!!");
		var xpos = $("text").attr('fill');
		alert(xpos);
		
		
		//getAllInfo()
	});
   */
   
  google.visualization.events.addListener(wordtree, 'select', getWbsInfo);
  // google.visualization.events.addListener(wordtree, 'select', getSubInfo); // addListener_select
  google.visualization.events.addListener(wordtree, 'ready', deleteWbs); // addListener_ready 
   
} 
/* end : WBS 트리 생성 */


/* WBS 트리 삭제하기 */	
   function deleteWbs(){
	 var reply = confirm("진짜 삭제? 데이터가 삭제되진 않음. 트리만 안보임");
	 if(reply) drawSimpleNodeChart(null, 0, 0); 
	 // wordtree.clearChart();
	 
	 // var num = nodeListData.getNumberOfRows();
	 // nodeListData.removeRows(0, num);
	 // wordtree.draw(nodeListData, options);
   } 


/* WBS 트리 정보 불러오기 */	
    
    var mlist_key = "";
	var p_no = ""; // Task 수정, 삭제시 projectNo 공유하기 위해 멤버 변수 선언.  
	function getWbs(projectNo){
	
		p_no = projectNo;
		
		$.ajax({
		  		url: "/planbe/wbs/getWbs",
		  		type: "post",
		  		data: {"projectNo" : projectNo},
		  		datatype: "json",
		  		success: function(result) {
                    alert("success에 들어옴");	
                    
                    var p_name = result.projectName;
                    var t_list = result.taskList; 	
		  			var m_list = result.memberList;
		  			
                    drawSimpleNodeChart(p_name, t_list, m_list);
                    memberForKey(m_list); // 나중에 다시!!!
				} // success
		});
	}
      
	/* 
	$("#selectError").on('change', function() {
	    alert( $(this).find(":selected").val() );
	});
	 */
	 
/* contains 메소드 추가 */
	Array.prototype.contains = function(element) {
		for (var i = 0; i < this.length; i++) {
			if (this[i] == element) {
				return true;
			}
		}
		return false;
	}
	 
/* 키워드 리스트 불러오기 */
    function memberForKey(m_list){
	     /* 멤버리스트 중복 제거  */
		 var array = [];
         array.push(m_list[0]);	

         for(var i=0; i<m_list.length; i++){
            if(array.contains(m_list[i])){
               continue;	
            }        	
            array.push(m_list[i]);
         }
		// alert(array);        
         
		 var data = "<option>-Select Keyword-</option>"
		          + "<optgroup label='Priority'>"
                  +	"<option value='high'>High</option>"
                  + "<option value='normal'>Normal</option>" 
		          + "<option value='low'>Low</option></optgroup>"
		          + "<optgroup label='Status'>"
		          + "<option value=ing'>ING</option>"
		          + "<option value='done'>DONE</option>"
		          + "<option value='plan'>PLAN</option></optgroup>"
		          + "<optgroup label='Member'>";
		          
         $(array).each(function(index, item) {
             data += "<option value=" + item + ">" + item + "</option>";
		 }); // for each 
        
		 data += "</optgroup>"
		 
	     $('#selectError').empty();
		 $('#selectError').append(data);
		 $("#selectError").trigger("liszt:updated");
    }
	   

/* 키워드별 TaskList 가져오기 */
/*    var select = document.getElementById("select_id");
   var option_value = select.options[select.selectedIndex].value;
   var option_text   = select.options[select.selectedIndex].text;
   
   // function TaskByKey(){
	   alert($("#selectError option:selected").val());
   // }
    */


	
	
/* WBS 노드 정보 불러오기 */ 
   // var p_list = "<c:out value='${p_list}'/>";
   // alert(p_list);
 
	function getWbsInfo() {

		var selectedNode = wordtree.getSelection();
	    var item = selectedNode.word;
    	
        if(proname == item){
	        	  alert("proname 클릭");
	        	  getAllTaskInfo(taskList, memberList); // all
	    }

    	
      	var selectTask = "";
      	var selectMember = "";
      	for(var i=0; i<taskList.length; i++){
        	   if(taskList[i].taskName == item){
            	 selectTask = taskList[i];
            	 selectMember = memberList[i];
			       getTaskInfo(selectTask, selectMember); 
			     //  $('.table table-striped table-bordered bootstrap-datatable datatable').trigger("liszt:updated");
			       break;
        	   }
        }
	}
	
		    	
      
/* projectName 클릭시, 프로젝트의 전체 taskList 가져오기 */	
	function getAllTaskInfo(taskList, memberList){
        
	    alert("getALLLLL");
		var mList = [];
		
		$(memberList).each(function(index, item) {
		     mList.push(item);	
		});
		
		$(".T_INFO").empty();
		
		$(taskList).each(function(index, item) {
		     $(".T_INFO").append("<tr><td class='center' id='member'><button class='btn btn-small btn-inverse'>" + mList[index] + "</button>"
		    		          + "</td><td class='center' id='taskName'>" + item.taskName 
		     		          + "</td><td class='center' id='taskContent'>" + item.taskContent 
		     		          + "</td><td class='center' id='taskPriority'>" + item.taskPriority 
		     		          + "</td><td class='center' id='taskStatus'>" + item.taskStatus
		     		          + "</td><td class='center' id='startDate'>" + item.startDate
		     		          + "</td><td class='center' id='dueDate'>" + item.dueDate
		     		          + "</td><td class='center' id='totalTime'>" + item.totalTime
		     		          + "</td><td class='center' id='doneTime'>" + item.doneTime 
		     		          + "</td><td><a class='btn btn-success' href=''#''>"
		     		          + "<i class='halflings-icon white zoom-in' onclick='taskForm()''></i></a>"
		     		          + "<a class='btn btn-info' href='#'>"
		     		          + "<i class='halflings-icon white edit' onclick='editTask()'></i></a>"
		     		          + "<a class='btn btn-danger' href='#'>"
		     		          + "<i class='halflings-icon white trash' onclick='deleteTask()'></i></a>"
		     		          + "<button class='btn btn-small btn-primary' onclick='updateWbs()'>SAVE</button>"
		     		          + "</td></tr>"
		     		          + "<input type='hidden' id ='taskNo' value=" + item.taskNo + ">");
		}); 
			
	}
	
	
    	
/* 개별 TaskInfo 가져오기 */
	function getTaskInfo(selectTask, selectMember){
	   		
	     $("#ttt").attr("class" , "table table-striped table-bordered bootstrap-datatable datatable");
	     
	     $(".T_INFO").empty();
	     $(".T_INFO").append("<tr><td class='center' id='member'><button class='btn btn-small btn-inverse'>" + selectMember + "</button>"
	    		          + "</td><td class='center' id='taskName'>" + selectTask.taskName 
	     		          + "</td><td class='center' id='taskContent'>" + selectTask.taskContent 
	     		          + "</td><td class='center' id='taskPriority'>" + selectTask.taskPriority 
	     		          + "</td><td class='center' id='taskStatus'>" + selectTask.taskStatus
	     		          + "</td><td class='center' id='startDate'>" + selectTask.startDate
	     		          + "</td><td class='center' id='dueDate'>" + selectTask.dueDate
	     		          + "</td><td class='center' id='totalTime'>" + selectTask.totalTime
	     		          + "</td><td class='center' id='doneTime'>" + selectTask.doneTime 
	     		          + "</td><td><a class='btn btn-success' href=''#''>"
	     		          + "<i class='halflings-icon white zoom-in' onclick='taskForm()''></i></a>"
	     		          + "<a class='btn btn-info' href='#'>"
	     		          + "<i class='halflings-icon white edit' onclick='editTask()'></i></a>"
	     		          + "<a class='btn btn-danger' href='#'>"
	     		          + "<i class='halflings-icon white trash' onclick='deleteTask()'></i></a>"
	     		          + "<button class='btn btn-small btn-primary' onclick='updateWbs()'>SAVE</button>"
	     		          + "</td></tr>"
	     		          + "<input type='hidden' id ='taskNo' value=" + selectTask.taskNo + ">");
	     
	     
	}       

/* TaskInfo 수정하기 */
	function editTask(){
		alert("edit");
		$(".center").prop("contenteditable", true);
	}
	
/* TaskInfo 수정사항 저장하기 */
	function updateWbs(){
		 var taskNo = $("#taskNo").val();
		 var taskName = $("#taskName").text(); 
		 var taskContent = $("#taskContent").text();
		 var taskPriority = $("#taskPriority").text(); 
		 var taskStatus = $("#taskStatus").text();
		 var startDate = $("#startDate").text();
		 var dueDate = $("#dueDate").text();
		 var totalTime = $("#totalTime").text();
		 var doneTime = $("#doneTime").text();
	 
		$.ajax({
	  		url: "/planbe/wbs/updateWbs",
	  		type: "post",
	  		data: {"projectNo" : p_no, 
	  			   "taskNo": taskNo, 
	  			   "taskName": taskName, 
	  			   "taskContent": taskContent,
	  			   "taskPriority": taskPriority,
	  			   "taskStatus": taskStatus, 
	  			   "startDate": startDate, 
	  			   "dueDate": dueDate, 
	  			   "totalTime": totalTime, 
	  			   "doneTime": doneTime},
	  			 
	  		success: function(result) {
                alert("success에 들어옴");	
                if(result) alert("수정 완료");
                else("수정 실패");
               
                $(".center").prop("contenteditable", false);
                getWbs(p_no);
			} // succes
	   });
   }
                
	  			
/* Task 삭제하기 */
	function deleteTask(){
		var reply = confirm("정말 Task 삭제?");
		if(reply){
			$.ajax({
		  		url: "/planbe/wbs/deleteTask",
		  		type: "post",
		  		data: {"taskNo": $("#taskNo").val()}, 
		  			 
		  		success: function(result) {
	                alert("success에 들어옴");	
	                if(result) alert("삭제 완료");
	                else("삭제 실패");
	                
	                $(".T_INFO").empty();
	                getWbs(p_no);
				} // succes
		   });		
		}
	}
		
	
  
/* Task 페이지로 이동 */
    function taskForm(){
	    location.href="/planbe/task/taskForm?projectNo=" + p_no;
    }

	
/* Gantt : gantt 페이지로 이동 */	
	function showGantt(){
		location.href="/planbe/gantt/ganttForm?projectNo=" + p_no; // url 확인해서 변경 필요.
	}


/* TEST */  
 // alert(nodeListData.getColumnLabel(0)); // id 
 // alert(nodeListData.getColumnProperties(0));   // [object, Object]
 // alert(nodeListData.getProperties(0, 0));      // [object, Object] 
 // alert(nodeListData.getRowProperties(0));      //  
 // alert(nodeListData.getValue(0, 0));           // 0
 // alert(nodeListData.getNumberOfColumns());     // 5 
	
</script>

<body>

<!-- Head Menu -->
	<div>
	<%@include file="headMenu.jsp"%>
    </div>
	
		<div class="container-fluid-full">
		<div class="row-fluid">
		
<!-- Side Menu -->
	<div>
     <%@include file="sideMenu.jsp"%>
    </div>	
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<!-- start: Content -->
			<div id="content" class="span10">
			
						
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.jsp">Main</a>
					<i class="icon-angle-right"></i> 
				</li>
				<li>
					<i class="icon-list-alt"></i>
					<a href="#">WBS</a>
				</li>
			</ul>
			
	
<!-- ========================================================================================================================== -->

			
<!-- 키워드 리스트 -->			
				<div class="box span2">
					<div class="box-header">
						<h2><i class="halflings-icon white eye-open"></i><span class="break"></span>Labels</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
			
					
						<table class="table table-bordered table-striped">
							<tbody>
							  <tr>
								<td>
								  <span class="label">Default</span>
								</td>
							  </tr>
							  <tr>
								<td>
								  <span class="label label-success">Success</span>
								</td>
							  </tr>
							  <tr>
								<td>
								  <span class="label label-warning">Warning</span>
								</td>
							  </tr>
							  <tr>
								<td>
								  <span class="label label-important">Important</span>
								</td>
							  </tr>
							  <tr>
								<td>
								  <span class="label label-info">Info</span>
								</td>
							  </tr>
							  <tr>
								<td>
								  <span class="label label-inverse">Inverse</span>
								</td>
							  </tr>
							</tbody>
						  </table>
					</div>
				</div><!--/span-->
<!-- 키워드 리스트 -->						
			
								
<!-- start : 프로젝트 리스트  -->			
	<div class="row-fluid sortable">	
				<div class="box span12">
					<div class="box-header">
						<h2><i class="halflings-icon white align-justify"></i><span class="break"></span>Project List</h2>
						<div class="box-icon">
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
						</div>
					</div>
					<div class="box-content">
					
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
							  <thead>
								  <tr>
									  <th>Project Name</th>
									  <th>Project Content</th>
									  <th>Project Status</th>
									  <th>Start Date</th>
									  <th>Due Date</th>
									  <th>Authority</th>                                          
								  </tr>
							  </thead>   
							  <tbody>
							  <c:forEach items="${p_list}" var="vo" varStatus="status">
								<tr>
									<td class="center">
									<button class="btn btn-mini btn-success" onclick="getWbs(${vo.projectNo})">${vo.projectName}</button>
									</td>                                       
									<td class="center">${vo.projectContent}</td>
									<td class="center">${vo.projectStatus}</td>
									<td class="center">${vo.startDate}</td>
									<td class="center">${vo.dueDate}</td>
									<td class="center">${m_list[status.index].projectAuthority}</td>
								</tr>
							  </c:forEach>
							  </tbody>
						 </table>  
					</div>
				</div><!--/span-->
			</div><!--/row-->
<!-- end : 프로젝트 리스트  -->		    			
				
								
<!-- start: WBS 트리 박스 -->			   
			<div class="row-fluid">	
	             <div class="box span12">
							<div class="box-header" />
								  <h2><i class="halflings-icon white list"></i><span class="break"></span>WBS</h2>
								  <div class="box-icon">
									<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
									<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
									<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
								  </div>
							</div>
	                        <div class="box-content" />

<!-- start : 키워드 드롭다운 -->
						  <div class="control-group" style="float: right;">
							<!-- 	<label class="control-label" for="selectError">Keyword Select</label> -->
								<div class="controls">
								  <select id="selectError" data-rel="chosen">
								  </select>
								</div>
						 </div>
<!-- end : 키워드 드롭다운 -->		

<!-- WBS 삭제 / Gantt 링크 버튼   -->                                  
                          <div id="wordtree_explicit" style="width: 850px; height: 500px;"></div>	
							    <button class="btn btn-small btn-danger" onclick="deleteWbs()">Delete WBS</button>
							    <button class="btn btn-small btn-warning" onclick="showGantt()">Show Gantt</button>
						  </div>
			      </div>
			  </div>
							
<!-- end: WBS 트리 박스 -->
	
<!-- start: Task List 박스 -->	
		<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white user"></i><span class="break"></span>Task List</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
						</div>
					</div>
					<div class="box-content">
					<table id="ttt" class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
							      <th>Member</th>
								  <th>Task Name</th>
								  <th>Task Content</th>
								  <th>Task Priority</th>
								  <th>Task Status</th>
								  <th>Start Date</th>
								  <th>Due Date</th>
								  <th>Total Time</th>
								  <th>Done Time</th>
								  <th>Action</th>
							  </tr>
						  </thead>   
<!-- TaskInfo 테이블 바디 -->		
						  <tbody class="T_INFO">
						  </tbody>
			
					  </table>     

<!-- 				         
							<a class="btn btn-success" href="#">
Task 페이지로 이동	    <i class="halflings-icon white zoom-in" onclick="taskForm()"></i>  
							</a>
							<a class="btn btn-info" href="#">
TaskInfo 수정		    <i class="halflings-icon white edit" onclick="editTask()"></i>  
							</a>
							<a class="btn btn-danger" href="#">
Task 삭제			    <i class="halflings-icon white trash" onclick="deleteTask()"></i> 
							</a>
수정된 TaskInfo Update							
                            <button class="btn btn-small btn-primary" onclick="updateWbs()">SAVE</button>
-->

					</div>
				</div><!--/span-->
			</div><!--/row-->
<!-- end: Task List 박스 -->		
	
							
<!-- 필요한 버튼 쓰려고 남겨둠 -->					
				<div class="box span6">
					<div class="box-header">
						<h2><i class="halflings-icon white list"></i><span class="break"></span>Buttons</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content buttons">
						<p>
							<button class="btn btn-large">Large button</button>
							<button class="btn btn-large btn-primary">Large button</button>
							<button class="btn btn-large btn-danger">Large button</button>
							<button class="btn btn-large btn-warning">Large button</button>
						</p>
						<p>
							<button class="btn btn-large btn-success">Large button</button>
							<button class="btn btn-large btn-info">Large button</button>
							<button class="btn btn-large btn-inverse">Large button</button>
						</p>
						<p>
							
						</p>
						<div class="btn-group">
							<button class="btn btn-large">Large Dropdown</button>
							<button class="btn btn-large dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></button>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="halflings-icon white star"></i> Action</a></li>
								<li><a href="#"><i class="halflings-icon white tag"></i> Another action</a></li>
								<li><a href="#"><i class="halflings-icon white download-alt"></i> Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#"><i class="halflings-icon white tint"></i> Separated link</a></li>
							</ul>
						</div>
						
						<hr>
						
						<p class="btn-group">
							  <button class="btn">Left</button>
							  <button class="btn">Middle</button>
							  <button class="btn">Right</button>
						</p>
						<p>
							<button class="btn btn-small"><i class="halflings-icon white white star"></i> Icon button</button>
							<button class="btn btn-small btn-primary">Small button</button>
							<button class="btn btn-small btn-danger">Small button</button>
							<button class="btn btn-small btn-warning">Small button</button>
							<button class="btn btn-small btn-success">Small button</button>
							
						</p>
						<p>
							<button class="btn btn-small btn-info">Small button</button>
							<button class="btn btn-small btn-inverse">Small button</button>
							<button class="btn btn-large btn-primary btn-round">Round button</button>
							<button class="btn btn-large btn-round"><i class="halflings-icon white white ok"></i></button>
							<button class="btn btn-primary"><i class="halflings-icon white white edit"></i></button>
						</p>
						<p>
							<button class="btn btn-mini">Mini button</button>
							<button class="btn btn-mini btn-primary">Mini button</button>
							<button class="btn btn-mini btn-danger">Mini button</button>
							<button class="btn btn-mini btn-warning">Mini button</button>
							<button class="btn btn-mini btn-info">Mini button</button>
							<button class="btn btn-mini btn-success">Mini button</button>
							<button class="btn btn-mini btn-inverse">Mini button</button>
						</p>
						
					</div>
				</div><!--/span-->
				
			</div><!--/row-->
			

	</div><!--/.fluid-container-->
	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->
		
	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">Ã</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
			<a href="#" class="btn btn-primary">Save changes</a>
		</div>
	</div>
	
	<div class="clearfix"></div>
	
	<footer>
		
		<p>
			<span style="text-align:left;float:left">&copy; 2017 <a href="/planbe/ourTeam" alt="Bootstrap_Metro_Dashboard">SCIT MASTER 33rd CLASS B TEAM 2 </a></span>
			
		</p>

	</footer>
	
<!--========================================================================================================= -->	
<!-- start: JavaScript-->
		<script src="/planbe/resources/bootstrap/js/jquery-1.9.1.min.js"></script>
	    <script src="/planbe/resources/bootstrap/js/jquery-migrate-1.0.0.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery-ui-1.10.0.custom.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.ui.touch-punch.js"></script>
		<script src="/planbe/resources/bootstrap/js/modernizr.js"></script>
		<script src="/planbe/resources/bootstrap/js/bootstrap.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.cookie.js"></script>
		<script src='/planbe/resources/bootstrap/js/fullcalendar.min.js'></script>
		<script src='/planbe/resources/bootstrap/js/jquery.dataTables.min.js'></script>
		<script src="/planbe/resources/bootstrap/js/excanvas.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.flot.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.flot.pie.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.flot.stack.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.flot.resize.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.chosen.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.uniform.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.cleditor.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.noty.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.elfinder.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.raty.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.iphone.toggle.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.uploadify-3.1.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.gritter.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.imagesloaded.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.masonry.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.knob.modified.js"></script>
		<script src="/planbe/resources/bootstrap/js/jquery.sparkline.min.js"></script>
		<script src="/planbe/resources/bootstrap/js/counter.js"></script>
		<script src="/planbe/resources/bootstrap/js/retina.js"></script>
		<script src="/planbe/resources/bootstrap/js/custom.js"></script>
<!-- end: JavaScript-->
	
</body>
</html>
	
	

	