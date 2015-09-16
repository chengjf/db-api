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
				<label for="comment" class="col-sm-2 control-label">评论</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="comment" name="comment" placeholder="评论"></div>
			</div>
			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">内容</label>
				<div class="col-sm-10">
					<textarea type="text" id="content" name="content" hidden></textarea>
				</div>
			</div>
			<div id="test-editormd" class="editormd editormd-vertical" ></div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<button type="button" class="btn btn-default" onclick="wikiSubmit();">提交</button>
				</div>
			</div>
		</form>
		
		
		<link rel="stylesheet" href="/editor/css/editormd.css">
		<link type="text/css" rel="stylesheet" href="/editor/lib/codemirror/codemirror.min.css">
		<link type="text/css" rel="stylesheet" href="/editor/lib/codemirror/addon/dialog/dialog.css">
		<link type="text/css" rel="stylesheet" href="/editor/lib/codemirror/addon/search/matchesonscrollbar.css">
		
		<script id="-lib-codemirror-codemirror-min" type="text/javascript" src="/editor/lib/codemirror/codemirror.min.js"></script>
		<script id="-lib-codemirror-modes-min" type="text/javascript" src="/editor/lib/codemirror/modes.min.js"></script>
		<script id="-lib-codemirror-addons-min" type="text/javascript" src="/editor/lib/codemirror/addons.min.js"></script>
		<script id="-lib-marked-min" type="text/javascript" src="/editor/lib/marked.min.js"></script>
		<script id="-lib-prettify-min" type="text/javascript" src="/editor/lib/prettify.min.js"></script>
		
		<script type="text/javascript" src="/editor/editormd.min.js"></script>
		<script type="text/javascript">
			
			var testEditor;

            $(function() {
                testEditor = editormd("test-editormd", {
                    width   : "70%",
                    height  : 640,
                    syncScrolling : "single",
                    path    : "/editor/lib/"
                });
            });
        
			
			wikiSubmit = function(){
				content = testEditor.getMarkdown();
				console.log(content);
				$('#content').val(content);
				$('#wiki-form').submit();
			};
		</script>
<#include "/layout/footer.ftl"/>
