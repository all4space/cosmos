$(function(){
	
	$("#delete").on("click",function(){
			
		if (confirm("삭제하시겠습니까?")) {
			document.form.action="/planbe/task/deleteTask"
			document.form.submit();
		}		
	});

	

});