<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Register</h2>

<form action="register" method="post">

Name: <input name="name"><br>
Email: <input name="email"><br>
Mobile: <input name="mobile"><br>
Username: <input name="uname"><br>
Password: <input type="password" name="pass"><br>

<button>Register</button>
</form>

<p style="color:red">${msg}</p>

</body>
</html>