<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Book List</title>
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
            <label name="username">
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="${ctx}/book/list">Book<span class="sr-only">(current)</span></a></li>
            <li ><a href="${ctx}/author/list">Author </a></li>

          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">BookStore</h1>
          <h4 style="color:red">${user.name}</h4>
				<form class="navbar-form" method="post">
					<div class="input-group">
						<span class="input-group-addon" id="name">姓名:</span>
						<input	type="text" class="form-control" name="name" value="${booksearch.name}">
					</div>

			
					<div class="input-group">
						<span class="input-group-addon" id="description">描述:</span> 
						<input	type="text" class="form-control" name="description"	value="${booksearch.description}">
					</div>

					<div class="input-group">
						<span class="input-group-addon" id="authorName">作者:</span> 
						<input	type="text" class="form-control" name="authorName"	value="${authorName}">
					</div>

					<div class="input-group">
						<span class="input-group-addon" id="status">状态:</span> 
									<select class="form-control" name="status" >
										<option value=0 <c:if test="${booksearch.status==0}">selected</c:if>>--全部--</option>
										<option value=1 <c:if test="${booksearch.status==1}">selected</c:if>>有效</option>
									</select>
					</div>

					<div class="input-group">
						<span class="input-group-addon" id="isDisplay">显示:</span>
								<select class="form-control" name="isDisplay">
										<option value=0 <c:if test="${booksearch.isDisplay==0}">selected</c:if>>--全部--</option>
										<option value=1 <c:if test="${booksearch.isDisplay==1}">selected</c:if>>显示</option>
									</select>
					</div>

					
          		<button type="submit" class="btn btn-primary">查询</button>
			  </form>


          <h2 class="sub-header">Book List</h2>

          <div class="row">
                    <div class="pull-right">
          	<a type="button" class="btn btn-primary navbar-btn" href="${ctx}/book/addinit">新增书籍</a>
          </div>
          </div>

				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>姓名</th>
								<th>描述</th>
								<th>作者</th>
								<th>状态</th>
								<th>显示</th>
								<th>更新人</th>
								<th>更新时间</th>
								<th>详情</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="book" items="${list}">
								<tr>
									<td>${book.name}</td>
									<td>${book.description}</td>
									<td>${book.author.name}</td>
									<c:if test="${book.status == 1}">
										<td>有效</td>
									</c:if>
									<c:if test="${book.status !=1}">
										<td>无效</td>
									</c:if>
									<c:if test="${book.isDisplay == 1}">
										<td>显示</td>
									</c:if>
									<c:if test="${book.isDisplay !=1}">
										<td>不显示</td>
									</c:if>
									<td>${book.updateUser}</td>
									<td><fmt:formatDate value="${book.updateTime}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><a class="btn btn-info" href="${book.id}/detail">Detail</a></td>
									<td><a class="btn btn-info" href="${book.id}/download">Download</a></td>
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