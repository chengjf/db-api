<#include "/layout/header.ftl"/> 
<link rel="stylesheet" type="text/css" href="/simditor/styles/simditor.css" />
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
					<input type="text" class="form-control" id="comment" name="comment" placeholder="创建时间" disabled value=${revision.page.createdDate?string("yyyy-MM-dd HH:mm:ss")}></div>
			</div>
		
			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">内容</label>
				<textarea  id="content" name="content" hidden>${revision.text.text}</textarea>
				<div id="test-editormd-view" class="markdown-body editormd-html-preview col-sm-8"></div>
			</div>
		</form>
		
		<link rel="stylesheet" href="/editor/css/editormd.css">
		<link type="text/css" rel="stylesheet" href="/editor/libs/codemirror/codemirror.min.css">
		<link type="text/css" rel="stylesheet" href="/editor/libs/codemirror/addon/dialog/dialog.css">
		<link type="text/css" rel="stylesheet" href="/editor/libs/codemirror/addon/search/matchesonscrollbar.css">
		
		<script id="-lib-codemirror-codemirror-min" type="text/javascript" src="/editor/libs/codemirror/codemirror.min.js"></script>
		<script id="-lib-codemirror-modes-min" type="text/javascript" src="/editor/libs/codemirror/modes.min.js"></script>
		<script id="-lib-codemirror-addons-min" type="text/javascript" src="/editor/libs/codemirror/addons.min.js"></script>
		<script id="-lib-marked-min" type="text/javascript" src="/editor/libs/marked.min.js"></script>
		<script id="-lib-prettify-min" type="text/javascript" src="/editor/libs/prettify.min.js"></script>
		<script type="text/javascript" src="/editor/editormd.min.js"></script>
		
		<script type="text/javascript">
            $(function() {
                var testEditormdView, testEditormdView2;
                console.log( $("#content").val());
			    testEditormdView = editormd.markdownToHTML("test-editormd-view", {
                    markdown        : $("#content").val(),
                    //htmlDecode      : true,       // 开启 HTML 标签解析，为了安全性，默认不开启
                    htmlDecode      : "style,script,iframe",  // you can filter tags decode
                    //toc             : false,
                    tocm            : true,    // Using [TOCM]
                    //tocContainer    : "#custom-toc-container", // 自定义 ToC 容器层
                    //gfm             : false,
                    //tocDropdown     : true,
                    // markdownSourceCode : true, // 是否保留 Markdown 源码，即是否删除保存源码的 Textarea 标签
                    emoji           : true,
                    taskList        : true,
                    tex             : true,  // 默认不解析
                    flowChart       : true,  // 默认不解析
                    sequenceDiagram : true,  // 默认不解析
                });
                    
            });
        </script>
		
		
<#include "/layout/footer.ftl"/>
