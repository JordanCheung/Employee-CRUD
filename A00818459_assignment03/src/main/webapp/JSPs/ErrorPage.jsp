<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page isErrorPage="true" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<jsp:include flush="true" page="/JSPs/Header.jsp"/>
	<p>An error has occurred. <a href="home">Back</a></p>
	<form method="post">
		<input type="submit" name="submit" id="submit" class="submit-button" value="Sign Out">
	</form>
</body>
</html>