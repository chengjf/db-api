<!doctype html>
<html>
<head>
	<title>SparkDemo</title>
	<meta charset="utf-8"/>
	<link href="${staticFilePath}/css/bootstrap.min.css?v=20150604" rel="stylesheet"/>
	<link href="${staticFilePath}/css/style.css" rel="stylesheet"/>
	<script src="${staticFilePath}/js/jquery.min.js"></script>
	<script src="${staticFilePath}/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="navbar navbar-duomi navbar-static-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/Admin/index.html" id="logo">CDMS接口管理系统</a>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
					<li class="active">
						<a href="#"> <i class="glyphicon glyphicon-th-large"></i>
							首页
						</a>
					</li>
					<li>
						<a href="#todo" class="nav-header collapsed" data-toggle="collapse"> <i class="glyphicon glyphicon-cog"></i>
							代办事项管理
							<span class="pull-right glyphicon glyphicon-chevron-down"></span>
						</a>
						<ul id="todo" class="nav nav-list collapse secondmenu" style="height: 0px;">
							<li>
								<a href="${baseUrl}/todo">
									<i class="glyphicon glyphicon-user"></i>
									查看代办事项
								</a>
							</li>
							<li>
								<a href="${baseUrl}/todo/add">
									<i class="glyphicon glyphicon-th-list"></i>
									添加代办事项
								</a>
							</li>

						</ul>
					</li>
					<li>
						<a href="#wiki" class="nav-header collapsed" data-toggle="collapse"> <i class="glyphicon glyphicon-cog"></i>
							Wiki管理
							<span class="pull-right glyphicon glyphicon-chevron-down"></span>
						</a>
						<ul id="wiki" class="nav nav-list collapse secondmenu" style="height: 0px;">
							<li>
								<a href="${baseUrl}/wiki">
									<i class="glyphicon glyphicon-user"></i>
									查看wiki
								</a>
							</li>
							<li>
								<a href="${baseUrl}/wiki/add">
									<i class="glyphicon glyphicon-th-list"></i>
									添加wiki
								</a>
							</li>

						</ul>
					</li>
					<!--				<li>
					<a href="./plans.html">
						<i class="glyphicon glyphicon-credit-card"></i>
						物料管理
					</a>
				</li>

				<li>
					<a href="./grid.html">
						<i class="glyphicon glyphicon-globe"></i>
						分发配置
						<span class="label label-warning pull-right">5</span>
					</a>
				</li>
				-->
				<li>
					<a href="#">
						<i class="glyphicon glyphicon-fire"></i>
						关于系统
					</a>
				</li>

			</ul>
		</div>
		<div class="col-md-10">