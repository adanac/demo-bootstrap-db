
<!-- /.modal -->
	<div id="stack1" class="modal fade" tabindex="-1" data-width="400"  data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
					<h4 class="modal-title">上传文件</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<form id="fileupload" name="fileuploadForm"  action=""  method="post" enctype="multipart/form-data">
								<h4>请选择要上传的文件</h4>
									<div class="form-group">
											<input type="file"   name="file" id="file" >
											<input type="hidden"  name="param" id="param" value="1">
											<input type="hidden"  name="url" id="url" value="/deptController/deptListPage.do">
									</div>
							</form>
						<a class="btn green" data-toggle="modal"  href="#stack2"  >错误提示</a>
						</div>
					</div>
				</div>
				<div class="modal-footer">
				
					<button type="button"  data-dismiss="modal" class="btn" id="close">关闭</button>
					<button type="button" class="btn blue" onclick="upload()" id="upd">确认导入</button>
				</div>
			</div>
		</div>
	</div>
	<div id="stack2" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
					<h4 class="modal-title">错误提示</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12" id="err">
							<p>无错误信息 </p>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal" class="btn">关闭</button>
					<button type="button" class="btn yellow" data-dismiss="modal">确认</button>
				</div>
			</div>
		</div>
	</div>
