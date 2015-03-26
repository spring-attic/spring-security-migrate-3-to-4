<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>

<html>
<head>
<title>Login</title>
</head>

<body>
	<h1>Login</h1>

	<c:url var="loginUrl" value="/j_spring_security_check" />
	<form action="${loginUrl}" method="post">
		<p>
			<label for="j_username">User:</label>
		</p>
		<input type="text" id="j_username" name="j_username" />

		<p>
			<label for="j_password">Password:</label>
		</p>
		<input type="password" id="j_password" name="j_password">

		<p>
			<label for="_spring_security_remember_me">Remember Me</label>
		</p>
		<input type="checkbox" id="_spring_security_remember_me"
			name="_spring_security_remember_me" />

		<div>
			<input name="submit" type="submit" />
		</div>
	</form>

</body>
</html>
