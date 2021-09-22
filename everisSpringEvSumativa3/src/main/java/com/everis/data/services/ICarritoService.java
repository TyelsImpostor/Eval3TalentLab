package com.everis.data.services;

import java.util.List;

import com.everis.data.models.Carrito;

public interface ICarritoService {
	public List<Carrito> findAll();
	public void agregarCarrito(Carrito carrito);
	public void comprar(Carrito carrito);
}
