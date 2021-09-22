package com.everis.data.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "carritos")
public class Carrito {
		
	//DATOS====================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int productoId;




	//FECHAS====================
	@Column(updatable = false)
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@UpdateTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Carrito() {
		super();
	}
	

	public Carrito(int productoId) {
		super();
		this.productoId = productoId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public int getProductoId() {
		return productoId;
	}


	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}


	
}
