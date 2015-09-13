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
				</tr>
			</thead>
			<tbody>
				<#list pageList as item>
					<tr>
						<td>${item.namespace}</td>
						<td>${item.title}</td>
						<td>${item.createdDate?string("yyyy-MM-dd")}</td>
						<td>${item.counter}</td>
					</tr>
				<#else>
				    <!--Part executed when there are 0 items-->
				</#list>
			</tbody>
		</table>
	</div>
<#include "/layout/footer.ftl"/>
