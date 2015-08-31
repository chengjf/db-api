<#include "/layout/header.ftl"/> 
	<div class="content">
		<#list todoList as item>
		    <li>${item.content}</item>
		<#else>
		    Part executed when there are 0 items
		</#list>
	</div>
<#include "/layout/footer.ftl"/>