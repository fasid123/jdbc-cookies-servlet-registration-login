<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make Payment</title>
</head>
<body>
<h5>From:</h5>

<form action="${pageContext.request.contextPath}/accvalidate" method="post">

<label for = "1">Account Holder Name :</label>
<input type = "text" name = "name" id = "1" />
<br>

<label for = "2">Account Number :</label>
<input type = "text" name = "accnumber" id = "2" />
<br>

<button type ="submit">Validate</button>



</form>
</body>
</html>