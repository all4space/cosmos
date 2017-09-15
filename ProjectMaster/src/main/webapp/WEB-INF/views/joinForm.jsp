<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>Join Page</title>
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
	
			<style type="text/css">
			body { background: url(/planbe/resources/bootstrap/img/bg-login.jpg) !important; }
		</style>
		
		
<script src="/planbe/resources/js/jquery-3.2.1.min.js"></script>		
</head>
<script>
   
   /* 회원 가입 양식 유효성 체크 */
   $(function() {
		  $("#join").click(function() {
			  
			  if($("#userId").val().length == 0){
				  alert("ID를 입력해 주세요");
				  $("#userId").focus();
				  return false;
			  } else if($("#userName").val().length == 0){
				  alert("이름을 입력해 주세요");
				  $("#userName").focus();
				  return false;
			  } else if($("#userPwd").val().length == 0){
				  alert("비밀번호를 입력해 주세요");
				  $("#userPwd").focus();
				  return false;
			  } else if($("#groupName").val().length == 0){
				  alert("그룹 이름을 입력해 주세요");
				  $("#groupName").focus();
				  return false;
			  }  else if(($("input[name*='authority']:checked").length)<=0){
				  alert("권한을 체크해 주세요");
				  return false;
			  } else if($("input[name*='authority']:checked").val() == "cto"){
			      ctoCheck(); 
				  return false;
			  }
			  document.fm.submit();
				  
		})
   });
   
   
   /* ID 중복 체크  */
   function idCheck() {
	     $.ajax({
			  url: "/planbe/users/idCheck", 
			  type: "post", 
			  data: {"userId" : $("#userId").val()}, 
			  success: function(result) {
				  if(result){
				    confirm("이미 존재하는 아이디");
				    $("#join").attr("disabled", "disabled"); 
				  } else {
					 confirm("사용 가능한 아이디");
					 $("#join").removeAttr("disabled");
				  }
			  }	  
		  });
   } 
	
  /* CTO UNIQUE 체크 : 한 그룹 안에 cto로 가입된 회원은 1명으로 한정 */
  function ctoCheck(){
	  $.ajax({
		  url: "/planbe/users/ctoCheck", 
		  type: "post", 
		  data: {"groupName" : $("#groupName").val()}, 
		  success: function(result) {
			  if(result){
			     confirm("CTO 권한이 없음! Manager or Member 선택해주세요");
			     $("#cto").click(); 
			     $("#cto").attr("disabled", true);
			  } else {
				 $("#join").removeAttr("disabled");
				 document.fm.submit();
			  }
		  }	  
	   });
  }
   
   
</script>

<style>
#checkId
{
	float: right;
	margin-right: 6%;
}
</style>

<body>
		<div class="container-fluid-full">
		<div class="row-fluid">
					
			<div class="row-fluid">
				<div class="login-box">
					<div class="icons">
						<a href="index.jsp"><i class="halflings-icon home"></i></a>
						<a href="#"><i class="halflings-icon cog"></i></a>
					</div>
					<h2>Create your account</h2>
					<form class="form-horizontal" name="fm" action="join" method="post">
						<fieldset>
							
							<div class="input-prepend" title="UserId">
								<span class="add-on"><i class="halflings-icon user"></i></span>
								<input class="input-large span10" name="userId" id="userId" type="text" placeholder="type userId"/>
							</div>
							<!-- 버튼 위치 조정 필요 -->
							    <span id = "checkId">
								<button type="button" class="btn btn-idCheck" onclick="idCheck()">중복 체크</button>
							    </span>
							    
							
							<div class="clearfix"></div>
							<div class="input-prepend" title="UserName">
								<span class="add-on"><i class="halflings-icon user"></i></span>
								<input class="input-large span10" name="userName" id="userName" type="text" placeholder="type userName"/>
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend" title="UserPwd">
								<span class="add-on"><i class="halflings-icon lock"></i></span>
								<input class="input-large span10" name="userPwd" id="userPwd" type="password" placeholder="type password"/>
							</div>
							<div class="clearfix"></div>
							
							<div class="clearfix"></div>
							<div class="input-prepend" title="GroupName">
								<span class="add-on"><i class="halflings-icon user"></i></span>
								<input class="input-large span10" name="groupName" id="groupName" type="text" placeholder="type groupName"/>
							</div>
							<div class="clearfix"></div>
                            
                            <div title="Authority"> 
								 
								 <div title="Authority"> 
		                         <label><input type="radio" name="authority" value="cto" id="cto" checked="checked"/> CTO</label>
		                         <label><input type="radio" name="authority" value="manager"/> Manager</label>
		                         <label><input type="radio" name="authority" value="member"/> Member</label>
		                         </div>
		                         
                            </div>
								
							<div class="button-join">	
							    <center>
								<button type="button" class="btn btn-join" id="join">Join</button>
							    </center>
							</div>
					</form>
							    
				</div><!--/span-->
			</div><!--/row-->
							
								 
                            
                                   
			

	</div><!--/.fluid-container-->
	
		</div><!--/fluid-row-->
	    <div class="common-modal modal fade" id="common-Modal1" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-content">
				<ul class="list-inline item-details">
					<li><a href="http://themifycloud.com">Admin templates</a></li>
					<li><a href="http://themescloud.org">Bootstrap themes</a></li>
				</ul>
			</div>
		</div>
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
