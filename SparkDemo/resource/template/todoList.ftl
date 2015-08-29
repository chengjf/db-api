<#include "/layout/header.ftl"/> 

	
<#list todoList as item>
    <li>${item.content}</item>
<#else>
    Part executed when there are 0 items
</#list>
	

<#include "/layout/footer.ftl"/>