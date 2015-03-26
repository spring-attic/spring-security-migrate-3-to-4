<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8"%>

<html>
<head>
<title>Login</title>
</head>

<body>
	<h1>Login</h1>

	<c:url var="loginUrl" value="/login" />
	<form:form action="${loginUrl}" method="post">
		<p>
			<label for="username">User:</label>
		</p>
		<input type="text" id="username" name="username" />

		<p>
			<label for="password">Password:</label>
		</p>
		<input type="password" id="password" name="password">

		<p>
			<label for="remember-me">Remember Me</label>
		</p>
		<input type="checkbox" id="remember-me"
			name="remember-me" />

		<div>
			<input name="submit" type="submit" />
		</div>
	</form:form>

</body>
</html>
