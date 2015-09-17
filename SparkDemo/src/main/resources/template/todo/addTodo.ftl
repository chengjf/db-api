<#include "/layout/header.ftl"/> 
	<form method='post' id='todo-form' action='${baseUrl}/todo/add'>
		<input type='text' name='content' id='content' value=''>
		<input type='submit' value='submit' form='todo-form'>
	</form>
<#include "/layout/footer.ftl"/>