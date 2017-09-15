$(document).ready(function () {
	
	  	
	    $('.btn-filter').on('click', function () {
 	
    var $target = $(this).data('target');
    if ($target != 'all') {
      $('.table tr').css('display', 'none');
      $('.table tr[data-status="' + $target + '"]').fadeIn('slow');
    } else {
  	  	location.href="/planbe/task/taskForm";
    }
  });
    
 
 });