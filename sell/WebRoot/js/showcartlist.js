$(document).ready(function(){
	$("#cartimg").click(function(){
		$.ajax({url:"/sell/jsp/ajaxcart.jsp",success:function(result){
			$("#showcart").html(result);
			$("#showcart").listview('refresh');
		}});
	});
});