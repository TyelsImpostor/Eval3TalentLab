<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrito</title>
</head>
<body>
	<div>
		<a href="/producto">Crear Producto</a>

		<form:form method="POST" action="/logout">
			<input type="submit" value="Cerrar sesion" />
		</form:form>

		<br>
		<hr>
		<div>
			<h1>Lista Productos</h1>
			<table>
				<thead>
					<tr>
						<th>#</th>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Stock</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${lista_productos}">
						<tr>
							<td><c:out value="${producto.id}" /></td>
							<td><c:out value="${producto.nombre}" /></td>
							<td><c:out value="${producto.precio}" /></td>
							<td><c:out value="${producto.stock}" /></td>
							<td>
								<form action="/carrito/agregar" method="POST">
									<input type="hidden" name="id"
										value="<c:out value="${producto.id}" />"> <input
										type="submit" value="Agregar">
								</form>

							</td>
						</tr>
					</c:forEach>

					<br>

				</tbody>
			</table>
		</div>
		<div>
			<p>
				Total: $
				<c:out value="${totalcarrito}" />
			</p>

		</div>
		<div>
			<form action="/carrito/comprar" method="post">
				<input type="submit" value="Comprar">
			</form>
		</div>
	</div>
</body>
</html>