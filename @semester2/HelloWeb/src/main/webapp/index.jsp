<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Hello Web</h1>
	<h2>Login</h2>
	
	<form action="login">
	
	<input type= "text" 
	placeholder ="What is your name?"
	name = user_name>
	
	<input type= "number" 
	min = "12" 
	placeholder ="What old are you?"
	name = user_age>
	
	<input type= "text" 
	placeholder ="What do you work?"
	name = user_job>
	
	<input type= "submit" value ="Send">
	</form>
</body>
</html>