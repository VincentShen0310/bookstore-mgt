<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Role List</title>
	<%@include file="../common/head.jsp"%>

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
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-1 sidebar">
          <ul class="nav nav-sidebar">
          </li>
            <li ><a href="${ctx}/book/list">Book </a></li>
            <li><a href="${ctx}/author/list">Author</a></li>
            <li class="active"><a href="${ctx}/role/list">Role<span class="sr-only">(current)</span></a></li>
          </ul>
        </div>

        <div class="col-sm-10 col-sm-offset-2 col-md-11 col-md-offset-1 main">
          <h1 class="page-header">BookStore</h1>
          
          <!-- 查询 -->
				<form class="navbar-form" method="post">
					<div class="input-group">
						<span class="input-group-addon" id="name">名称:</span>
						<input	type="text" class="form-control" name="name" value="${rolesearch.name}">
					</div>

			
					<div class="input-group">
						<span class="input-group-addon" id="description">描述:</span> 
						<input	type="text" class="form-control" name="description"	value="${rolesearch.description}">
					</div>


					<div class="input-group">
						<span class="input-group-addon" id="status">状态:</span> 
									<select class="form-control" name="status">
										<option value=0 <c:if test="${rolesearch.status==0}">selected</c:if>>--全部--</option>
										<option value=1 <c:if test="${rolesearch.status==1}">selected</c:if>>有效</option>
									</select>
					</div>
			
          		<button type="submit" class="btn btn-primary">查询</button>
			  </form>

<!-- 列表 -->
          <h2 class="sub-header">Role List</h2>

          <div class="row">
                    <div class="pull-right">
          	<a type="button" class="btn btn-primary navbar-btn" data-href="${ctx}/role/addinit">新增角色</a>
          </div>
          </div>
          
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>名称</th>
                  <th>描述</th>
                  <th>状态</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="role" items="${list}">
                <tr>
                  <td>${role.name}</td>
                  <td>${role.description}</td>
					<c:if test="${role.status == 1}">
						<td>有效</td>
					</c:if>
					<c:if test="${role.status !=1}">
						<td>无效</td>
					</c:if>
				<td><a class="btn btn-info" data-toggle="modal" data-href="${role.id}/detail">Detail</a></td>
                </tr>
            </c:forEach>
               </tbody>
            </table>
<!-- 分页 -->          
					<div class="pull-right">
						<nav aria-label="Page navigation">
							<ul class="pagination">
								<li><a href="#" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">6</a></li>
								<li><a href="#" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
        </div>
      </div>
    </div>

    <div class="modal fade" id="modify-modal1" tabindex="-1" role="dialog" aria-labelledby="modal-label"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span>
                    <span class="sr-only">关闭</span></button>
                    <h4 class="modal-title" id="modal-label">修改角色</h4>
                </div>
                <div class="modal-body">
					<form class="form-horizontal" id="modalForm" class="form-horizontal" enctype="multipart/form-data">
						<div class="form-group">
							<label for="name" class="col-sm-3 control-label">角色名称</label>
							<div class="col-sm-7">
								<input class="form-control" type="text" name="name" value="${roledetail.name}" >
							</div>
						</div>
					</form>
				</div>
                <div class="modal-footer">
                	<button type="button" class="btn btn-primary" data-interface="/add">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                </div>
            </div>
        </div>
    </div>


</body>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="${ctx}/resources/js/common/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script	src="${ctx}/resources/js/common/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${ctx}/resources/js/common/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${ctx}/resources/js/common/ie10-viewport-bug-workaround.js"></script>
    <script src="${ctx}/resources/js/common/bootstrap-switch.min.js"></script>
    
</html>