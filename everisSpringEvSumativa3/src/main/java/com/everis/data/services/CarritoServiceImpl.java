package com.everis.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Carrito;
import com.everis.data.repositories.CarritoRepository;

@Service
public class CarritoServiceImpl implements ICarritoService{
	
	@Autowired
	private CarritoRepository cr;

	public List<Carrito> findAll() {
		return cr.findAll();
	}

	public void agregarCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		cr.save(carrito);
	}

	@Override
	public void comprar(Carrito carrito) {
		// TODO Auto-generated method stub
		cr.delete(carrito);
	}
	
	
}
