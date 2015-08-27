<#include "/layout/header.ftl"/> 
<body>
	
<#list todoList as item>
    <li>${item}</item>
<#else>
    Part executed when there are 0 items
</#list>
	
</body>
<#include "/layout/footer.ftl"/>