<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
<h1>Register</h1>
<form action="RegisterServlet" method="post">
<label for="username">Username:</label>
<input type="text" id="username" name="Username" required><br>
<label for="username">Email:</label>
<input type="text" id="Email" name="Email" required><br>
<label for="password">password</label>
<input type="password" id="password" name="Password" required><br>
<button type="submit">Register</button>

</form>
<p><a href="index.jsp">Back to Home</a></p>

 <%-- Display error message if registration fails --%>
        <% String error = request.getParameter("error");
           if (error != null && error.equals("1")) { %>
            <p style="color: red;">Registration failed. Please try again.</p>
        <% } %>
</div>
</body>
</html>