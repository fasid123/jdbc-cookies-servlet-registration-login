<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>
<h1>Registration</h1>

<form action="${pageContext.request.contextPath}/accregister" method="post">


<label for="name">Name:</label>
<input type ="text" name="name" id="name"/>
<br>

<label for="email">Email:</label>
<input type="text" name="email" id="email"/>
<br>

<label for = "mobile">Mobile:</label>
<input type = "text" name = "mobile" id = "mobile"/>
<br>

<label for = "balance">Initial Amount:</label>
<input type = "text" name = "balance" id = "balance"/>
<br>

<label for = "username">UserName:</label>
<input type = "text" name = "uname" id = "username"/>
<br>

<label for = "password">Password:</label>
<input type = "password" name = "pass" id = "password"/>
<br>

<button type = "submit">Register</button>

</form>
</body>
</html>