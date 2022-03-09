<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cardholder Portal</title>
</head>
<%-- <form name='loginForm'
	action="<c:url value='login' />" method='POST'>
	<table>
		<tr>
			<td>User ID:</td>
			<td><input type='text' name='username' value=''></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='password' /></td>
		</tr>
		<tr>
			<td colspan='2'><input name="login" type="submit"
				value="Login" /></td>
		</tr>
	</table>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form> --%>

<form:form id="loginForm" method="post" action="processLogin"
	modelAttribute="userBean">
	<form:label path="username">User ID:</form:label>
	<form:input id="username" name="username" path="username" />
	<br>
	<form:label path="username">Password:</form:label>
	<form:password id="password" name="password" path="password" />
	<br>
	<input type="submit" value="Login" />
</form:form>
</body>
</html>