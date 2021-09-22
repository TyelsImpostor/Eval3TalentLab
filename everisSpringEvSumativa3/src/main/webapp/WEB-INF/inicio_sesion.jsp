<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio sesion</title>
</head>
<body>
	<div>
		<form:form action="/ingresar" method="post" >
			
        <p>
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="contrasena">Password</label>
            <input type="password" id="contrasena" name="contrasena"/>
        </p>
			
			<input type="submit" value="Iniciar Sesion">
		</form:form>
		<br>
		<a href="/registro">Registrarse</a>
	</div>
</body>
</html>