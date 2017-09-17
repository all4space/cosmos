<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>STATISTIC</title>
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
	
		<meta name="description" content="chart created using amCharts live editor" />
		
		<!-- amCharts javascript sources -->
		<script type="text/javascript" src="https://www.amcharts.com/lib/3/amcharts.js"></script>
		<script type="text/javascript" src="https://www.amcharts.com/lib/3/serial.js"></script>
		<script type="text/javascript" src="https://www.amcharts.com/lib/3/themes/light.js"></script>	
	
		<script type = "text/javascript" src="/planbe/resources/js/jquery-3.2.1.min.js"></script>
</head>
<script>
$(function(){
	projectIng();
	circle_progess();
})
 	function projectIng(){
	
		var pNo_list = ${projectNo_list};
		var result = [];
		
		$(pNo_list).each(function(index,item){
			result.push(item);
		})
			$.ajax({
		  		url: "/planbe/static/getProjectList",
		  		type : "post",
		  		data : { "pnoList" : result },
		  		datatype: "json",
		  		success: function(result) {
		  			alert("성공~!"); 
		  			var projectList = result.projectList;
		  			var percent = result.taskList;
			  		setEfficiency(projectList, percent);
			  		circle_progess();
				}, // success
		  		error: function() {	alert("통신 에------라!");	}
			})
	} 
	
	/*업무 효율 그래프  */
	 function setEfficiency(projectList, percent){
		listUp(projectList, percent);
		var color = ['circleStatsItemBox yellow','circleStatsItemBox green','circleStatsItemBox red','circleStatsItemBox pink','circleStatsItemBox blue','circleStatsItemBox green'];
		$(projectList).each(function(index1,item1){ // user가 속한 project들의 VO정보들 name,content,status...
			$(percent).each(function(index2,item2){ //percent 계산 하기 위해가져온 taskVO time들
				if(item1.projectNo == item2.projectNo){
					var percen = (item2.doneTime / item2.totalTime) * 100;
					var percent = Math.round(percen); // 퍼센트 계산 했고, data 는 한번만 찍어야해. 
					
					var day = howlong(item1.dueDate);
					
					var data  = '<div class = "span2" onTablet="span4" onDesktop="span2">';
						data	 += '<div class = "'+color[index1]+'">';
						data	 += '<div class = "header">'+projectList[index1].projectName+'</div>';
						data	 += '<span class="percent">percent</span>';
						data	 += '<div class="circleStat">';
						data	 += '<input type = "text" value = "'+percent+'" class = "whiteCircle" />';
						data	 += '</div>';
						data	 += '<div class = "footer">';
						data	 +=	'<span class = "count">';
						data	 += '<span class = "numbers">D</span>';
						data	 += '<span class = "unit"></span>';
						data	 += '</span>';
						data	 += '<span class = "sep"> </span>';
						data	 += '<span class = "value">';
						data	 += '<span class = "number"></span>';
						data	 += '<span class = "units">'+day+' Day</span>';
						data	 += '</span>';
						data	 += '</div>'; // footer
						data	 += '</div>'; // color
						data	 += '</div>'; // span
					$("#allchart").append(data);
				}//if 문				
			})//taskVO 포이치(= projectNo 같은 놈 탐색)
		})//ProjectVO 포이치(= 프로젝트별로 나타내기 위해...)
	}//setEfficiency 함수 끗.
	
	/* 남은 기한(d-day) 구하기   */
	function howlong(dueDate){
		var due = new Date(dueDate); // 종료날짜
		var now = new Date();// 시스템 날짜
		
		var betweenDay = (due.getTime() - now.getTime())/1000/60/60/24 ;
		var bD = Math.floor(betweenDay);
		
		if(betweenDay > 0 ){
			bD = "+"+bD;
		}else{
			bD = "-"+bD;
		}
		return bD;
	}
	
	/* 프로젝트 리스트를 띄움 */
	function listUp(projectList){
			$(projectList).each(function(index,item){
				var addRow = '<option value = "'+item.projectNo+'">'
						 + item.projectName
						 +'</option>';
						 
			 $("#selectError").html(addRow);
			})
			$("#selectError").trigger("liszt:updated");
	}
/*----------------------------------------------------------------------------------------------------------------- */	
	/* 업무별 진행률  */
/*----------------------------------------------------------------------------------------------------------------- */		
	/* listUp에서 고른 project의 task들의 진행도를 보여줌  */
	function progressOfTask(projectNo){
		
			
		alert("task 진입 :" + projectNo.value );
		$.ajax({
	  		url: "/planbe/static/getTaskList",
	  		type : "post",
	  		data : { "projectNo" : projectNo.value },
	  		datatype: "json",
	  		success: function(result) {
	  			alert("progress result 성공!");
	  			var taskList = result.taskList;
	  			var usersNamelist = result.usersNamelist;
	  			makeProgress(taskList,projectNo,usersNamelist);
	  			$(".verticalChart").empty();
	  			whoIsBest(usersNamelist);
	  			chart();
			}, // success
	  		error: function() {	alert("통신 에------라!");	}
		})
		
		/* 진행률 그래프 그리는 펑션  */
		function makeProgress(taskList,projectNo,usersNamelist){
				var task = []; // taskList data 모은 배열
				
			$(taskList).each(function(index,item){
				if(projectNo.value == item.projectNo){
					/*doneper = 퍼센트 구하기  */
					var	 done = ( item.doneTime / item.totalTime ) * 100;
					var doneper = Math.round(done);
					
					if(doneper > 50){ // 그래프가 1:1 이라서...
						var difference = doneper - 50;
						var addDone = 50 - difference;
					}else{addDone = 50;}
					
					task[index] = {"category" : item.taskName, "doneTime" : doneper, "totalTime" : addDone };
				}//if문 번호비교
			})//foreach tasklist 뺌
				AmCharts.makeChart("chartdiv",{
							"type": "serial",
							"categoryField": "category",
							"rotate": true,
							"startDuration": 1,
							"theme": "light",
							"categoryAxis": {
								"gridPosition": "start"
							},
							"trendLines": [],
							"graphs": [
								{
									"balloonText": "[[title]] of [[category]]:[[value]]",
									"fillAlphas": 1,
									"id": "AmGraph-1",
									"title": "진행률",
									"type": "column",
									"valueField": "doneTime"
								},
								{
									"balloonText": "[[title]] of [[category]]:[[value]]",
									"fillAlphas": 1,
									"id": "AmGraph-2",
									"title": "전체 업무량",
									"type": "column",
									"valueField": "totalTime"
								}
							],
							"guides": [],
							"valueAxes": [
								{
									"id": "ValueAxis-1",
									"stackType": "100%",
									"title": ""
								}
							],
							"allLabels": [],
							"balloon": {},
							"legend": {
								"enabled": true,
								"useGraphSettings": true
							},
							"titles": [
								{
									"id": "Title-1",
									"size": 15,
									"text": "업무별 진행률"
								}
							],
							"dataProvider": task
						}
					);//am 끝
			}//make 펑션
			
	}
	
	/* 랭킹 테스트 */
    function whoIsBest(t_list){
	   
	   var NoArray = []; 
       var NameArray = []; 
       
       for(var i=0; i<t_list.length; i++){
    	   if(!NoArray.contains(t_list[i].memberNo)){
              NoArray.push(t_list[i].memberNo);
              NameArray.push(t_list[i].userName);
           }
       }
     /*   alert(NoArray); // 3,5,2 */ 	    
      //   alert(NameArray);
     
       var objArray = [];
       for(var i=0; i < NoArray.length; i++){
    	   // if(!NoArray.contains(t_list[i].memberNo)){
	         var obj = {
		          m_no : NoArray[i], 
		          m_name : NameArray[i],
		          rate : 0,
		          count : 0
	         }
    	   // }
          /*   alert(obj.m_no); // */
            objArray.push(obj);
	   }

     /*   alert(objArray[0].m_no); // 3 */
       
       for(var i=0; i<t_list.length; i++){
    	   var doneTime = t_list[i].doneTime.toFixed(2);
      	   var totalTime = t_list[i].totalTime.toFixed(2); 
      	   var rate = (doneTime/totalTime).toFixed(2)*100; 
           
      	   for(var j=0; j<objArray.length; j++){
      		   if(t_list[i].memberNo == objArray[j].m_no){
      			   objArray[j].rate += rate; 
      			   objArray[j].count += 1;
      		   }
      	   }
       }
      			   
       alert(objArray[0].m_no); // 3
       alert(objArray[0].m_name); // 미현
       alert(objArray[0].rate); // 300
       alert(objArray[0].count); // 5 */
       
	$(objArray).each(function(index,item){
		var donePer = null;
		alert(item.rate); alert(item.count);
		if(item.rate >= 100){
			donePer = item.rate / item.count ;
			alert(donePer);
		}else{
			alert(donePer);
			donePer = item.rate;
		}
		var oneBar = '<div class="singleBar" style = "margin: 10px 10px 10px 10px">';
			oneBar += '<div class="bar">';
			oneBar += '<div class="value">';
			oneBar += '<span>'+donePer+'%</span>';
			oneBar += '</div>';
			oneBar += '</div>';
			oneBar += '<div class="title">'+item.m_name+'</div>';
			oneBar += '</div>';
			oneBar += '<div></div>';
		$(".verticalChart").append(oneBar);
	})	
	
    }//function 
	 
/* contains 메소드 추가 */
	Array.prototype.contains = function(element) {
		for (var i = 0; i < this.length; i++) {
			if (this[i] == element) {
				return true;
			}
		}
		return false;
		
		

	}
	
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
				<li><a href="#">Statistic</a></li>
			</ul>

			<div class="row-fluid">																				<!-- 전체 효율 -->
			<div onTablet="span6" onDesktop="span6"> <!--  class="widget span6"  -->
					<h2><div class="control-group">
						<label class="control-label" for="selectError">Plz select one by project List. You can see its progress of disease from the project of task List. </label>
						<div class="controls">
						  <select id="selectError" data-rel="chosen" onchange="progressOfTask(this)" >
						  </select>
						</div>
					  </div>					
					</h2>
					<hr>
					<div id = "allchart" class="row-fluid hideInIE8 circleStats"></div>
				</div>
			</div><!--/row-->
							
				<div class="box">
					<div class="box-header">
						<h2><i class="halflings-icon white list-alt"></i><span class="break"></span>TASK List</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					<div id="chartdiv" style="width: 100%; height: 400px; background-color: #FFFFFF;" ></div>
					</div>
				</div>
				
			<div class="row-fluid">
			<!-- 	<div class="box span6">
					<div class="box-header">
						<h2><i class="halflings-icon white list-alt"></i><span class="break"></span>Ranking</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div> -->
					<div class="box-content">
							<!-- <div id="ranking">랭킹  -->
									<div class="widget blue span5" onTablet="span6" onDesktop="span5">
										<h2><span class="glyphicons globe"><i></i></span> 담당자별 업무 효율 랭킹</h2>
										<hr>
										<div class="content">
											<div class="verticalChart">
												<div class="clearfix"></div>
											</div><!-- /verticalChart -->
										</div><!--/content  -->
									<!-- </div>/span -->											
							</div>
					</div>
				</div>
			
<!-- 				<div class="box span6">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white list-alt"></i><span class="break"></span>Donut</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						 <div id="donutchart" style="height: 300px;"></div>
					</div>0
				</div>
			
			</div>/row
		
			<hr>
		
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header">
						<h2><i class="halflings-icon white list-alt"></i><span class="break"></span>Realtime</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						 <div id="realtimechart" style="height:190px;"></div>
						 <p>You can update a chart periodically to get a real-time effect by using a timer to insert the new data in the plot and redraw it.</p>
						 <p>Time between updates: <input id="updateInterval" type="text" value="" style="text-align: right; width:5em"> milliseconds</p>
					</div>
				</div>
			</div>/row
			
			<div class="row-fluid">
				
				<div class="widget span6" onTablet="span6" onDesktop="span6">
					<h2><span class="glyphicons facebook"><i></i></span>Facebook Fans</h2>
					<hr>
					<div class="content">
						<div id="facebookChart" style="height:300px" ></div>
					</div>
				</div>/span
				
				<div class="widget span6" onTablet="span6" onDesktop="span6">
					<h2><span class="glyphicons twitter"><i></i></span>Twitter Followers</h2>
					<hr>
					<div class="content">
						<div id="twitterChart" style="height:300px" ></div>
					</div>
				</div>/span
			
			</div>
					<div class="box">
					<div class="box-header">
						<h2><i class="halflings-icon white list-alt"></i><span class="break"></span>Flot</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<div id="flotchart" class="center" style="height:300px"></div>
					</div>
				</div>	 -->
		

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
	<div class="common-modal modal fade" id="common-Modal1" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<ul class="list-inline item-details">
				<li><a href="http://themifycloud.com">Admin templates</a></li>
				<li><a href="http://themescloud.org">Bootstrap themes</a></li>
			</ul>
		</div>
	</div>
	
	<div class="clearfix"></div>
	
	<footer>

		<p>
			<span style="text-align:left;float:left">&copy; 2017 <a href="/planbe/ourTeam" alt="Bootstrap_Metro_Dashboard">SCIT MASTER 33rd CLASS B TEAM 2 </a></span>
			
		</p>

	</footer>
	
	
	<!-- start: JavaScript-->
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

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
