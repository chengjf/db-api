<#include "/layout/header.ftl"/> 
	<form class="form-horizontal" id="wiki-form" >
			<div class="form-group">
				<label for="namespace" class="col-sm-2 control-label">主题</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="namespace" name="namespace" placeholder="主题" disabled value=${revision.page.namespace}>
				</div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">标题</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="title" name="title" placeholder="标题" disabled value=${revision.page.title}></div>
			</div>
			<div class="form-group">
				<label for="type" class="col-sm-2 control-label">类型</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="type" name="type" placeholder="类型" disabled value=${revision.text.type}></div>
			</div>
			
			<div class="form-group">
				<label for="comment" class="col-sm-2 control-label">评论</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="comment" name="comment" placeholder="评论" disabled value=${revision.page.comment}></div>
			</div>
			<div class="form-group">
				<label for="createdDate" class="col-sm-2 control-label">创建时间</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="comment" name="comment" placeholder="创建时间" disabled value=${revision.page.createdDate?string("yyyy-MM-dd")}></div>
			</div>
		
			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">内容</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="content" name="content" placeholder="内容" disabled value=${revision.text.text}></div>
			</div>
		</form>
<#include "/layout/footer.ftl"/>
