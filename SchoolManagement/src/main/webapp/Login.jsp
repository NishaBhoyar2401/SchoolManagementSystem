<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
<h1>Login</h1>
<form action="LoginServlet" method="post">
<label for="username">Username:</label>
<input type="text" id="username" name="user" required><br>
<label for="password">password:</label>
<input type="password" id="password" name="pwd" required><br>

<button type="submit">Login</button>

</form>
<p><a href="index.jsp">Back to Home</a></p>
        <% String error =request.getParameter("error");
		if(error != null && error.equals("1")){ %>
		<p style="color:red;">Invalid user name and password,please try again.</p>
		<% } %>
		
		
		<% String rs =request.getParameter("registration");
		if(rs != null && rs.equals("success")){ %>
		<p style="color:green;">Your Registration successfull.please login</p>
		<% } %>
</div>
</html>