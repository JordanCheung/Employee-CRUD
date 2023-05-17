<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:include flush="true" page="/JSPs/Header.jsp"/>
	<form action="j_security_check" method="POST">
		<table>
			<tr><td>Username: <input type="TEXT" name="j_username"></td></tr>
			<tr><td>Password: <input type="PASSWORD" name="j_password"></td></tr>
			<tr><th><input type="SUBMIT" value="Log in"></th></tr>
		</table>
	</form>
</body>
</html>