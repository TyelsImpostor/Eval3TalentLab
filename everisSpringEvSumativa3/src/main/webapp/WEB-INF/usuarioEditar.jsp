<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Usuario</title>
</head>
<body>
	<div>
		<form:form action="/usuario/modificar" method="post" modelAttribute="usuario">
			<input type="hidden" name="_method" value="put">
			<form:input type="hidden" path="id" />
			<br>

			<p>
				<form:label path="nombre">Nombre:</form:label>
				<form:input type="text" path="nombre" />
			</p>
			<p>
				<form:label path="email">Email:</form:label>
				<form:input type="email" path="email" />
			</p>
			<p>
				<form:label path="contrasena">Password:</form:label>
				<form:password path="contrasena" />
			</p>
			<p>
				<form:label path="passwordConfirmation">Confirmación Password:</form:label>
				<form:password path="passwordConfirmation" />
			</p>

			<input type="submit" value="Editar">
		</form:form>
	</div>
</body>
</html>