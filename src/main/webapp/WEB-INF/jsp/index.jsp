<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>BookStore Management</title>
	<%@include file="common/head.jsp"%>
</head>

<body>
    <div class="container">

      <form class="form-signin" style="width:400px; margin:auto" method="post" action="${ctx}/book/list">
        <h2 class="form-signin-heading">BookStore Management</h2>
            <div class="input-group">
      			<span class="input-group-addon" id="username">账号:</span>
      			<input  type="text" class="form-control" name="username" placeholder="用户名" required autofocus>
    		</div>
			</br>
            <div class="input-group">
      			<span class="input-group-addon" id="password">密码:</span>
      			<input  type="password" class="form-control" name="password" placeholder="密码" required autofocus>
    		</div>
			</br>
        <button class="btn btn-primary btn-block" type="submit">登录</button>
      </form>

    </div>
</body>
<%@include file="common/footer.jsp"%>
</html>
