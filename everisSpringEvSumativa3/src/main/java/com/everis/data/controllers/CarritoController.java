package com.everis.data.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Carrito;
import com.everis.data.models.Producto;
import com.everis.data.services.CarritoServiceImpl;
import com.everis.data.services.ProductoService;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

	@Autowired
	private ProductoService ps;
	
	@Autowired
	private CarritoServiceImpl cs;
	
	@RequestMapping("")
	public String inicio(Model model, @ModelAttribute("carrito") Carrito carrito) {
		int total = 0;
		model.addAttribute("lista_productos", ps.findAll());
		List<Carrito> carritos = cs.findAll();
		for(Carrito i: carritos) {
			Long id = new Long(i.getProductoId());
			Producto p = ps.buscarProducto(id);
			total += p.getPrecio();
		}
		model.addAttribute("totalcarrito", total);
		model.addAttribute("lista_carritos", carritos);
		model.addAttribute("carrito", new Carrito());
		return "carrito.jsp";
	}
	
	
	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
	public String agregar(@Valid @RequestParam("id") int id) {
		Producto producto = ps.buscarProducto(new Long(id));
		if(producto.getStock() > 0) {
			producto.setStock(producto.getStock()-1);
			Carrito carrito = new Carrito(id);
			cs.agregarCarrito(carrito);
			ps.modificarProducto(producto);
			return "redirect:/carrito";
		}else {
			System.out.println("No hay mas stock disponible");
		}
	
		return "redirect:/carrito";
	}
	
	@RequestMapping(value = "/carrito/{id}", method = RequestMethod.GET)
	public String carritoAñadir(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("usuarioId") != null) {

			return "usuarioEditar.jsp";
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/carrito/comprar", method = RequestMethod.POST)
	public String carritoComprar(Model model, HttpSession session) {
		if (session.getAttribute("usuarioId") != null) {

			System.out.println("Comprado!");

			
			List<Carrito> carritos = cs.findAll();
			for (Carrito i : carritos) {
				cs.comprar(i);
				
			}
			
			return "usuarioEditar.jsp";
		}
		return "redirect:/login";
	}
	
}
