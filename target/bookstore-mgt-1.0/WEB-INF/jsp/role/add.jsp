<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!-- 标题 -->
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title">编辑角色</h4>
</div>
<!-- 表单 -->
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
<!-- 按钮区域 -->
<div class="modal-footer">
    <button type="button" class="btn btn-primary j-save" data-interface="/role/update">保存</button>
    <button type="button" class="btn btn-default j-close" data-dismiss="modal">关闭</button>
</div>