<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<p>
		Message <b><c:out value="${message}" /></b>
	</p>
	<p>
		<form:form action="./logout" method="post">
			<input type="submit" value="Log Out"/>
		</form:form>
	</p>

	<sec:authorize access="hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')">
		<p>Must have ROLE_ADMIN and ROLE_USER</p>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
		<p>Must have ROLE_ADMIN or ROLE_USER</p>
	</sec:authorize>
	<sec:authorize access="!hasAnyRole('ROLE_ADMIN','ROLE_USER')">
		<p>Must not have ROLE_ADMIN or ROLE_USER</p>
	</sec:authorize>
</body>
</html>
