<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jsp page</title>
</head>
<body>

<h1> ${username}</h1>

<h1> <%= request.getAttribute("username") %></h1>

<% for(int i = 1; i <= 5; i++) { %>
    <h1>Hello</h1>
<% } %>

</body>
</html>