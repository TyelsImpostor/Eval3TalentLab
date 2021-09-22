<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pagina de Registro</title>
</head>
<body>
    <h1>Registrate!</h1>
    
    <!-- <p><form:errors path="usuario.*"/></p> -->
    
    <form:form method="POST" action="/registrar" modelAttribute="usuario">
    	<p>
            <form:label path="nombre">Nombre:</form:label>
            <form:input type="text" path="nombre"/>
        </p>
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
        </p>
        <p>
            <form:label path="contrasena">Contraseña:</form:label>
            <form:password path="contrasena"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Repita la Contraseña:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Registrate!"/>
    </form:form>
    
</body>
</html>