package com.everis.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long>{
	//List<Carrito> findAll();
	//public List<Carrito> findAll();
	//public void agregarCarrito(Carrito carrito);
}
