<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login</h2>

<p style="color:red">${error}</p>

<form action="signin" method="post">
Username: <input name="uname"><br>
Password: <input type="password" name="pass"><br>
<button>Login</button>
</form>

</body>
</html>