<#include "/layout/header.ftl"/> 
<body>
	<form method='post' id='todo-form' action='/todo/add'>
		<input type='text' name='content' id='content' value=''>
		<input type='submit' value='submit' form='todo-form'>
	</form>
</body>
<#include "/layout/footer.ftl"/>