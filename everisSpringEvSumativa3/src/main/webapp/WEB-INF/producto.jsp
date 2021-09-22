<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
</head>
<body>
	<div>	
		<form:form method="POST" action="/logout">
			<input type="submit" value="Cerrar sesion" />
		</form:form>
		<!--<c:forEach var="usuario" items="${usuario_sesion}">
			<a href="/producto/actualizar/${usuario.id}">aaaaaaaaaa</a>
		</c:forEach>
		-->

		<form:form action="/producto/crear" method="post"
			modelAttribute="producto">
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre" />
			<br>

			<form:label path="precio">precio:</form:label>
			<form:input type="text" path="precio" />
			<br>

			<form:label path="stock">stock:</form:label>
			<form:input type="text" path="stock" />
			<br>

			<form:label path="descripcion">descripcion:</form:label>
			<form:input type="text" path="descripcion" />
			<br>

			<input type="submit" value="Crear Producto">
		</form:form>
		<br>
		<hr>
		<h1>Lista de Productos</h1>
		<hr>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Stock</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="producto" items="${lista_productos}">
					<tr>
						<td><c:out value="${producto.id}" /></td>
						<td><c:out value="${producto.nombre}" /></td>
						<td><c:out value="${producto.precio}" /></td>
						<td><c:out value="${producto.stock}" /></td>
						<td><a href="/producto/actualizar/${producto.id}">Editar</a>
							<form action="/producto/eliminar" method="POST">
								<input type="hidden" name="id"
									value="<c:out value="${producto.id}" />"> <input
									type="submit" value="Eliminar">
							</form></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>