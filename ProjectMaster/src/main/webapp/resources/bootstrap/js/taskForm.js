$(function(){
	
	$('#searchbtn').on('click',function(){
			
		var searchtype=$('#searchtype').val();
		var searchword=$('#searchword').val();

		
		if (searchword == null) {
			alert("검색어를 입력하세요");
		}else{		
		location.href="/planbe/task/taskForm?searchtype="+searchtype+"&searchword="+searchword;
		}
	});

	
	//$('input:checkbox[id="checkbox1"]').is(":checked") == true){
	
	
	 $(".chbox").change(function(){
						 
	        if($(".chbox").is(":checked")){
	        	
				$(".title").addClass("selected");         
	        	
	        }else{
	        	$(".title").removeClass("selected"); 
	        }
	    });
	 
	 $("#excel").on("click", function () {
		 		
	        var $preparingFileModal = $("#preparing-file-modal");
	        $preparingFileModal.dialog({ modal: true });
	        $("#progressbar").progressbar({value: false});
	        $.fileDownload("/planbe/task/ExcelDownload", {
	            successCallback: function (url) {
	                $preparingFileModal.dialog('close');
	            },
	            failCallback: function (responseHtml, url) {
	                $preparingFileModal.dialog('close');
	                $("#error-modal").dialog({ modal: true });
	            }
	        });
	        // 버튼의 원래 클릭 이벤트를 중지 시키기 위해 필요합니다.
	        return false;
	    });

	
		
	
});