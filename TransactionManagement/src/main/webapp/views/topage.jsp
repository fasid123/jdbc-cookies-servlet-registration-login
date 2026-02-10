<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Transfer</title>
</head>
<body>
<p>Balance is : ${balance}</p>


<h1>To :</h1>

<form action="${pageContext.request.contextPath}/transaction" method="post">

<input type="hidden" name="fromAcc" value="${accNum}" />
<input type="hidden" name="fromBalance" value="${balance}" />

<label for ="1">Account Number : </label>
<input type = "text" name = "accnumber" id = "1"/>
<br>

<label for ="2">Amount : </label>
<input type = "text" name = "amounts" id = "2"/>
<br>

<button type ="submit"> Submit</button>

</form>
</body>
</html>