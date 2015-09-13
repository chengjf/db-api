<#include "/layout/header.ftl"/> 
	<div class="content">
		<table  class="table table-bordered table-striped table-hover">
			<caption>ALL Wiki</caption>
			<thead>
				<tr>
					<td>主题</td>
					<td>名称</td>
					<td>创建日期</td>
					<td>点击量</td>
					<td>详细</td>
				</tr>
			</thead>
			<tbody>
				<#list wikiList as item>
					<tr>
						<td>${item.page.namespace}</td>
						<td>${item.page.title}</td>
						<td>${item.page.createdDate?string("yyyy-MM-dd")}</td>
						<td>${item.page.counter}</td>
						<td><a href="/wiki/${item.revisionId}">详情</a></td>
					</tr>
				<#else>
				    <!--Part executed when there are 0 items-->
				</#list>
			</tbody>
		</table>
	</div>
<#include "/layout/footer.ftl"/>
