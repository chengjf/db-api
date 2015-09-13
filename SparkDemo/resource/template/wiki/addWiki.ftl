<#include "/layout/header.ftl"/> 
	<form class="form-horizontal" id="wiki-form" action='/wiki/add' method="post">
			<div class="form-group">
				<label for="namespace" class="col-sm-2 control-label">主题</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="namespace" name="namespace" placeholder="主题"></div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">标题</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="title" name="title" placeholder="标题"></div>
			</div>
			<div class="form-group">
				<label for="type" class="col-sm-2 control-label">类型</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="type" name="type" placeholder="类型"></div>
			</div>
			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">内容</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="content" name="content" placeholder="内容"></div>
			</div>
			<div class="form-group">
				<label for="comment" class="col-sm-2 control-label">评论</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="comment" name="comment" placeholder="评论"></div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<input type="submit" class="btn btn-default" form='wiki-form'/>
				</div>
			</div>
		</form>
<#include "/layout/footer.ftl"/>
