<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>TASK</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link id="bootstrap-style" href="/planbe/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="/planbe/resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="/planbe/resources/bootstrap/css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="/planbe/resources/bootstrap/css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	<link href="/planbe/resources/bootstrap/css/EasyTable.css" rel="stylesheet">
	<link href="/planbe/resources/bootstrap/css/search.css" rel="stylesheet">
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
	
</head>

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
				<li><a href="#">Task</a></li>
			</ul>

			
			
		<!-- admin인 경우 -->
			
			<c:if test="${loginId == 'admin'}">
			
			<div class="title-1">
			<legend><h1>${loginId}님의 Task</h1></legend>
			</div>
			<div class="row-fluid">				
				<div class="span7">
				
				<!-- 프로젝트 리스트 가져오기 시작 -->
				
				<div class="container">
    <div class="row">
        <div class="col-sm-3 col-md-2">
            <div class="btn-group">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    Mail <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Mail</a></li>
                    <li><a href="#">Contacts</a></li>
                    <li><a href="#">Tasks</a></li>
                </ul>
            </div>
        </div>
        <div class="col-sm-9 col-md-10">
            <!-- Split button -->
            <div class="btn-group">
                <button type="button" class="btn btn-default">
                    <div class="checkbox" style="margin: 0;">
                        <label>
                            <input type="checkbox">
                        </label>
                    </div>
                </button>
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <span class="caret"></span><span class="sr-only">Toggle Dropdown</span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">All</a></li>
                    <li><a href="#">None</a></li>
                    <li><a href="#">Read</a></li>
                    <li><a href="#">Unread</a></li>
                    <li><a href="#">Starred</a></li>
                    <li><a href="#">Unstarred</a></li>
                </ul>
            </div>
            <button type="button" class="btn btn-default" data-toggle="tooltip" title="Refresh">
                   <span class="glyphicon glyphicon-refresh"></span>   </button>
            <!-- Single button -->
            <div class="btn-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    More <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Mark all as read</a></li>
                    <li class="divider"></li>
                    <li class="text-center"><small class="text-muted">Select messages to see more actions</small></li>
                </ul>
            </div>
            <div class="pull-right">
                <span class="text-muted"><b>1</b>–<b>50</b> of <b>277</b></span>
                <div class="btn-group btn-group-sm">
                    <button type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </button>
                    <button type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </button>
                </div>
            </div>
        </div>
    </div>
    <hr />
    <div class="row">
        <div class="col-sm-3 col-md-2">
            <a href="#" class="btn btn-danger btn-sm btn-block" role="button">COMPOSE</a>
            <hr />
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#"><span class="badge pull-right">42</span> Inbox </a>
                </li>
                <li><a href="http://www.jquery2dotnet.com">Starred</a></li>
                <li><a href="http://www.jquery2dotnet.com">Important</a></li>
                <li><a href="http://www.jquery2dotnet.com">Sent Mail</a></li>
                <li><a href="http://www.jquery2dotnet.com"><span class="badge pull-right">3</span>Drafts</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-md-10">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs">
                <li class="active"><a href="#home" data-toggle="tab"><span class="glyphicon glyphicon-inbox">
                </span>Primary</a></li>
                <li><a href="#profile" data-toggle="tab"><span class="glyphicon glyphicon-user"></span>
                    Social</a></li>
                <li><a href="#messages" data-toggle="tab"><span class="glyphicon glyphicon-tags"></span>
                    Promotions</a></li>
                <li><a href="#settings" data-toggle="tab"><span class="glyphicon glyphicon-plus no-margin">
                </span></a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane fade in active" id="home">
                    <div class="list-group">
                        <a href="#" class="list-group-item">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox">
                                </label>
                            </div>
                            <span class="glyphicon glyphicon-star-empty"></span><span class="name" style="min-width: 120px;
                                display: inline-block;">Bhaumik Patel</span> <span class="">This is big title</span>
                            <span class="text-muted" style="font-size: 11px;">- Hi hello how r u ?</span> <span
                                class="badge">12:10 AM</span> <span class="pull-right"><span class="glyphicon glyphicon-paperclip">
                                </span></span></a><a href="#" class="list-group-item">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox">
                                        </label>
                                    </div>
                                    <span class="glyphicon glyphicon-star-empty"></span><span class="name" style="min-width: 120px;
                                        display: inline-block;">Bhaumik Patel</span> <span class="">This is big title</span>
                                    <span class="text-muted" style="font-size: 11px;">- Hi hello how r u ?</span> <span
                                        class="badge">12:10 AM</span> <span class="pull-right"><span class="glyphicon glyphicon-paperclip">
                                        </span></span></a><a href="#" class="list-group-item read">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox">
                                                </label>
                                            </div>
                                            <span class="glyphicon glyphicon-star"></span><span class="name" style="min-width: 120px;
                                                display: inline-block;">Bhaumik Patel</span> <span class="">This is big title</span>
                                            <span class="text-muted" style="font-size: 11px;">- Hi hello how r u ?</span> <span
                                                class="badge">12:10 AM</span> <span class="pull-right"><span class="glyphicon glyphicon-paperclip">
                                                </span></span></a>
                    </div>
                </div>
                <div class="tab-pane fade in" id="profile">
                    <div class="list-group">
                        <div class="list-group-item">
                            <span class="text-center">This tab is empty.</span>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade in" id="messages">
                    ...</div>
                <div class="tab-pane fade in" id="settings">
                    This tab is empty.</div>
            </div>
            <!-- Ad -->
            <div class="row-md-12">
                <div class="ad">
                    <a href="http://www.jquery2dotnet.com" class="title">jQuery2DotNet</a>
                    <div>
                        Cool jQuery, CSS3, HTML5, Bootstrap, and MVC tutorial</div>
                    <a href="http://www.jquery2dotnet.com" class="url">www.jquery2dotnet.com</a>
                </div>
            </div>
        </div>
    </div>
</div>

</div>	
						
</div>
			
 </c:if>

		
	<!-- 프로젝트 리스트 가져오기 끝 -->	
			
	  <!-- admin인 경우 끝 -->
	  
	  <!-- admin이 아닌 경우 시작 -->
       
    
    
       
      <div class="container">
	<div class="row">
		
	<!-- admin이 아닌 경우 -->
       
      <c:if test="${loginId !='admin'}">
      
   <form  action="/planbe/task/updateTask" method="POST" name="form">	     
     <div class="container">
	<div class="row">
        <div class="col-sm-12">
            <legend><h1>${loginId}님의 UpdateTask</h1></legend>
        </div>
        <!-- panel preview -->
      
        <div class="col-sm-5">
            <h4>Update Task:</h4>
            <div class="panel panel-default">
                <div class="panel-body form-horizontal payment-form">
                	
                	<c:if test="${updateTask !=null}">
                	
                  <table>                
                    <tr>
                      <th>ProjectNo</th>
                     <td>                                                              
                         <input type="text" id="projectNo" name="projectNo" readonly="readonly" value="${updateTask.projectNo}" style="width:20px"> 
                         <input type="hidden" id="memberNo" name="memberNo" readonly="readonly" value=" ${updateTask.memberNo}">  
                         <input type="hidden" id="taskNo" name="taskNo" readonly="readonly" value="${updateTask.taskNo}">    

                      </td>                         
                    </tr>
                                  
                  	<tr>
                    	<th>TaskName</th>
                     <td>
                         <input type="text" class="name" id="taskName" name="taskName" value="${updateTask.taskName}">
                     </td> 
                    </tr>
                    
                    <tr>
                       <th>Content</th>
                     	<td>                                             
                       		<textarea class="form-control" id="taskContent" name="taskContent">${updateTask.taskContent}</textarea>
                      </td> 
                    </tr> 
                                    
                    <tr>
                     <th>Priority</th>
                     <td>
                         <select  id="taskPriority" name="taskPriority">
                         	<c:choose>
                         	  <c:when test="${updateTask.taskPriority =='urgent'}">
                         	  		<option>--선택--</option>
                         	  		<option selected>urgent</option>
                         	  		<option>good</option>
                         	  		<option>disaster</option>
                         	  </c:when>
                         	  <c:when test="${updateTask.taskPriority =='good'}">
                         	  		<option>--선택--</option>
                         	  		<option >urgent</option>
                         	  		<option selected>good</option>
                         	  		<option>disaster</option>
                         	  </c:when>
                         	  <c:when test="${updateTask.taskPriority =='disaster'}">
                         	  		<option>--선택--</option>
                         	  		<option>urgent</option>
                         	  		<option>good</option>
                         	  		<option selected>disaster</option>
                         	  </c:when>
                         	  <c:otherwise>
                         	  		<option selected>--선택--</option>
                         	  		<option>urgent</option>
                         	  		<option>good</option>
                         	  		<option>disaster</option>
                         	  </c:otherwise>
                         	</c:choose>
                            </select>   
                       </td>                     
                    </tr>
                    
                     <tr>
                     <th>Status</th>
                     <td>
                         <select  id="taskStatus" name="taskStatus">
                         	<c:choose>
                         	  <c:when test="${updateTask.taskStatus =='new'}">
                         	  		<option>--선택--</option>
                         	  		<option selected>new</option>
                         	  		<option>ongoing</option>
                         	  		<option>done</option>
                         	  </c:when>
                         	  <c:when test="${updateTask.taskStatus =='ongoing'}">
                         	  		<option>--선택--</option>
                         	  		<option >new</option>
                         	  		<option selected>ongoing</option>
                         	  		<option>new</option>
                         	  </c:when>
                         	  <c:when test="${updateTask.taskStatus =='done'}">
                         	  		<option>--선택--</option>
                         	  		<option>new</option>
                         	  		<option>ongoing</option>
                         	  		<option selected>done</option>
                         	  </c:when>
                         	  <c:otherwise>
                         	  		<option selected>--선택--</option>
                         	  		<option>new</option>
                         	  		<option>ongoing</option>
                         	  		<option>done</option>
                         	  </c:otherwise>
                         	</c:choose>
                            </select>   
                       </td>                     
                    </tr>
                                                                    
                    <tr>
                     <th>StarDate</th>
                      <td>                    
                         <input type="date" class="form-control" id="startDate" name="startDate" value="${updateTask.startDate}">
                        
                      </td>                        
                    </tr> 
                    
                    <tr>
                     <th>DueDate</th>
                     <td>
                        <input type="date" class="form-control" id="dueDate" name="dueDate" value="${updateTask.dueDate}">
                      <td>      
                    </tr>
                    
                     <tr>
                     <th>TotalTime</th>
                      <td>                    
                         <input type="text" class="form-control" id="totaltime" name="totalTime" style="width:20px" value="${updateTask.totalTime}">시간
                      </td>      
                    </tr>
                    
                     <tr>
                     <th>DoneTime</th>
                      <td>                    
                         <input type="text" class="form-control" id="donetime" name="doneTime" style="width:20px" value="${updateTask.doneTime}" >시간
                      </td>      
                    </tr>
                    
                    
                  </table> 
                  
                  </c:if>
                  
               
                    <div class="form-group">                   
                        <div class="col-sm-12 text-right">
                            <input type="submit" class="btn btn-default preview-add-button" value="Update" id="updateTask">
                                <span class="glyphicon glyphicon-plus"></span> 
                             <input type="button" class="btn btn-default preview-add-button" value="Delete" id="delete" >
                              <span class="glyphicon glyphicon-plus"></span> 
                                                                               
                            <a href="/planbe/task/taskForm/"><button type="button" class="btn btn-default preview-cancel-button">
                                <span class="glyphicon glyphicon-plus"></span> cancel
                            </button></a>
                            
                        </div>
                    </div>
                                          
                                 
                </div>
            </div>            
        </div> <!-- / panel preview -->
  
      </div>
   </div>
    </form>      
  </c:if>
<!-- admin이 아닌 경우 끝 -->
																
	
	</div>
		 
		
</div>

<!-- admin이 아닌 경우 끝 --> 		
			
       

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
		
		<script src="/planbe/resources/bootstrap/js/updateTask.js"></script> <!-- updateTask jquery 링크 -->
		
		<script src="/planbe/resources/bootstrap/js/deleteTask.js"></script>
		
	<!-- end: JavaScript-->
	
</body>
</html>
