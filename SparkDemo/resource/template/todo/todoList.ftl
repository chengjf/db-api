<#include "/layout/header.ftl"/> 
	<div class="content">
		<#list todoList as item>
		    <li><strong>${item.id}</strong> ${item.content} <span>Added Time: ${item.createdDate?string("yyyy-MM-dd HH:mm:ss")}</span></item>
		<#else>
		    Part executed when there are 0 items
		</#list>
	</div>
<#include "/layout/footer.ftl"/>