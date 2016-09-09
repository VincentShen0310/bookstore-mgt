//    $(document).ready(function(){
//    	$(".pagination>li").find("a").click(function(){
//            $(".pagination").find("li").removeClass("active");
//            $(this).parent("li").addClass("active");
//    	});
//    });
    
    function changeCurrentPage(currentPage) {
    	$("#currentPage").val(currentPage);
    	$("#navbar-form").submit();
    };


