<#include "/layout/header.ftl"/> 
	<div class="content">
		<table  class="table table-bordered table-striped table-hover">
			<caption>ALL TODO</caption>
			<thead>
				<tr>
					<td>ID</td>
					<td>内容</td>
					<td>创建日期</td>
					<td>是否完成</td>
				</tr>
			</thead>
			<tbody>
				<#list todoList as item>
					<tr>
						<td>${item.id}</td>
						<td>${item.content}</td>
						<td>${item.createdDate?string("yyyy-MM-dd HH:mm:ss")}</td>
						<td>${item.completed?string('yes', 'no')}</td>
					</tr>
				<#else>
				    Part executed when there are 0 items
				</#list>
			</tbody>
		</table>
	</div>
<#include "/layout/footer.ftl"/>
