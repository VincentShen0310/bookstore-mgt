<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>Author Detail</title>
  <%@include file="../common/head.jsp"%>
  <!-- Bootstrap core CSS -->
  <link href="${ctx}/resources/css/bootstrap.min.css" rel="stylesheet">
  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <link href="${ctx}/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="${ctx}/resources/css/dashboard.css" rel="stylesheet">
  <link href="${ctx}/resources/images/common/favicon.ico" rel="shortcut icon">
  <link href="${ctx}/resources/css/bootstrap-switch.min.css" rel="stylesheet">
  <link href="${ctx}/resources/css/fileinput.min.css" rel="stylesheet" type="text/css"/>
</head>

<body>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">BookStore Management</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li>
            <a href="#">Dashboard</a>
          </li>
          <li>
            <a href="#">Settings</a>
          </li>
          <li>
            <a href="#">Profile</a>
          </li>
          <li>
            <a href="#">Help</a>
          </li>
        </ul>
        <form class="navbar-form navbar-right">
          <input type="text" class="form-control" placeholder="Search..."></form>
      </div>
    </div>
  </nav>

  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
          <li >
            <a href="${ctx}/book/list">Book</a>
          </li>
          <li class="active">
            <a href="${ctx}/author/list">
              Author
              <span class="sr-only">(current)</span>
            </a>
          </li>
        </ul>
      </div>
      <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <h1 class="page-header">BookStore</h1>

        <h2 class="sub-header">Author Detail</h2>
        
  <form class="form-horizontal" action="edit" method="post" enctype="multipart/form-data">

    <div class="input-group">
      <span class="input-group-addon" id="name">姓名:</span>
      <input  type="text" class="form-control" name="name" value="${authordetail.name}">
    </div>
    </br>

    <div class="input-group">
      <span class="input-group-addon" id="description">描述:</span>
      <input  type="text" class="form-control" name="description" value="${authordetail.description}">
    </div>
  </br>

    <div class="input-group">
      <span class="input-group-addon" id="status">状态:</span>
      <div class="switch">
        <c:if test="${authordetail.status == 1}">
          <input type="checkbox" name="status" value="1" checked/>
        </c:if>
         <c:if test="${authordetail.status != 1}"> 
           <input type="checkbox" name="status" value="1"/> 
         </c:if> 

      </div>
    </div>
    </br>

    <div class="input-group">
      <span class="input-group-addon" id="isDisplay">显示:</span>
      <div class="switch">
        <c:if test="${authordetail.isDisplay == 1}">
          <input type="checkbox" name="isDisplay" value="1" checked/>
        </c:if>
        <c:if test="${authordetail.isDisplay != 1}">
          <input type="checkbox" name="isDisplay" value="1" />
        </c:if>
      </div>
    </div>
    </br>

<!--     <div class="input-group"> -->
<!--       <input id="inputFile" class="file" type="file" name="upfile" data-min-file-count="0"> -->
<!--     </div> -->
<!-- 	</br> -->
	
    <button type="submit" class="btn btn-primary">保存</button>
    <a type="button" class="btn btn-default" href="${ctx}/author/list">返回</a>
  </form>
  
      </div>
    </div>
  </div>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${ctx}/resources/js/common/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${ctx}/resources/js/common/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="${ctx}/resources/js/common/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${ctx}/resources/js/common/ie10-viewport-bug-workaround.js"></script>
<script src="${ctx}/resources/js/common/bootstrap-switch.min.js"></script>
<script src="${ctx}/resources/js/common/fileinput.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/js/common/fileinput_locale_zh.js" type="text/javascript"></script>
<script type="text/javascript">
    $("[name='status']").bootstrapSwitch();
    $("[name='isDisplay']").bootstrapSwitch();
	$("#inputFile").fileinput({
		showUpload : false, //是否显示上传按钮
		showPreview: true,//是否预览图片	
		allowedFileExtensions : [ 'jpg', 'png', 'txt'] //允许上传的图片类型
	});

	function UpdaLoadImage(){
		Controller.call(this);
		this.createUpdaLoadImage();
	}

	UpdaLoadImage.prototype.createUpdaLoadImage = function(){
		var t = this;

		$('#btnValid').click(function() {
			$('#result').html("");
			var formData = new FormData($("#importForm")[0]);

			$.ajax({
				url : '${ctx}/author/{authordetail.id}/edit',
				type : 'POST',
				data : formData,
				async : false,
				cache : false,
				contentType : false,
				processData : false,
				success : function(rtn) {
					$("#result").html("图片地址：" + rtn.message);
				},
				error : function(returndata) {
					t.tips('保存失败！', 2);
				}
			});
		});
	}

	$(document).ready(function(){
		new UpdaLoadImage();
	});
</script>
  
</html>