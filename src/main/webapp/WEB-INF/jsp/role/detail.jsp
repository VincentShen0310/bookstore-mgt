<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
    <div class="modal fade" id="modify-modal" tabindex="-1" role="dialog" aria-labelledby="modal-label"
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