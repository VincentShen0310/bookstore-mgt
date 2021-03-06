<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Author List</title>
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
          <li>
            <a href="#">Welcome ${user.name}</a>
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
        <form class="navbar-form navbar-right" action="${ctx}/logout">
          <input type="text" class="form-control" placeholder="Search...">
          <button type="submit" class="btn btn-primary">注销</button>
         </form>
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
				<form class="navbar-form" id="navbar-form" method="post">
				
				<input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
				
					<div class="input-group">
						<span class="input-group-addon" id="name">姓名:</span>
						<input	type="text" class="form-control" name="name" value="${authorsearch.name}">
					</div>

			
					<div class="input-group">
						<span class="input-group-addon" id="description">描述:</span> 
						<input	type="text" class="form-control" name="description"	value="${authorsearch.description}">
					</div>


					<div class="input-group">
						<span class="input-group-addon" id="status">状态:</span> 
									<select class="form-control" name="status" >
										<option value=0 <c:if test="${authorsearch.status==0}">selected</c:if>>--全部--</option>
										<option value=1 <c:if test="${authorsearch.status==1}">selected</c:if>>有效</option>
									</select>
					</div>

					<div class="input-group">
						<span class="input-group-addon" id="isDisplay">显示:</span>
								<select class="form-control" name="isDisplay" value="${authorsearch.status}">
										<option value=0 <c:if test="${authorsearch.isDisplay==0}">selected</c:if>>--全部--</option>
										<option value=1 <c:if test="${authorsearch.isDisplay==1}">selected</c:if>>显示</option>
									</select>
					</div>

					
          		<button type="submit" class="btn btn-primary">查询</button>
			  </form>


          <h2 class="sub-header">Author List</h2>

          <div class="row">
                    <div class="pull-right">
          	<a type="button" class="btn btn-primary navbar-btn" href="${ctx}/author/addinit">新增作者</a>
          </div>
          </div>
          
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>姓名</th>
                  <th>描述</th>
                  <th>状态</th>
                  <th>显示</th>
                  <th>更新人</th>
                  <th>更新时间</th>
                  <th>详情</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="author" items="${list}">
                <tr>
                  <td>${author.name}</td>
                  <td>${author.description}</td>
					<c:if test="${author.status == 1}">
						<td>有效</td>
					</c:if>
					<c:if test="${author.status !=1}">
						<td>无效</td>
					</c:if>
					<c:if test="${author.isDisplay == 1}">
						<td>显示</td>
					</c:if>
					<c:if test="${author.isDisplay !=1}">
						<td>不显示</td>
					</c:if>
					<td>${author.updateUser}</td>
					<td><fmt:formatDate value="${author.updateTime}"	pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><a class="btn btn-info" href="${author.id}/detail">Detail</a></td>
				<td><a class="btn btn-info" href="${author.id}/download">Download</a></td>
                </tr>
            </c:forEach>
               </tbody>
            </table>
					<%@include file="../common/pagination.jsp"%>					
			</div>
        </div>
      </div>
    </div>

</body>
	<%@include file="../common/footer.jsp"%>
</html>