package com.everis.data.controllers;

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

import com.everis.data.models.Usuario;
import com.everis.data.services.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService us;

	//================INICIO====================
	@RequestMapping("")
	public String redirect() {
		return "redirect:/login";
	}
	@RequestMapping("/login")
	public String login() {
		return "inicio_sesion.jsp";
	}
	// =================CREAR====================
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuario usuario) {
		return "registro_usuario.jsp";
	}

	@RequestMapping("/registrar")
	public String registrar(@Valid @ModelAttribute("usuario") Usuario usuario) {
		
		if (usuario.getContrasena().length() == 0 ) {
			System.out.println("La Contraseña no puede estar vacia");
		} else if (usuario.getContrasena().length() < 5 || usuario.getContrasena().length() > 20){
			System.out.println("La Contraseña debe tener entre 5 y 20 caracteres");
		} else if (usuario.getNombre().length() == 0 ) {
			System.out.println("El campo Nombre no puede estar vacio");
		} else if (usuario.getNombre().length() < 4 || usuario.getNombre().length() > 15){
			System.out.println("El Nombre debe tener entre 4 y 15 caracteres");
		} else if (usuario.getEmail().length() == 0 ) {
			System.out.println("El campo Email no puede estar vacio");
		} else if (usuario.getEmail().length() < 7 || usuario.getEmail().length() > 20){
			System.out.println("El Email debe tener entre 7 y 20 caracteres");
		}else if (!usuario.getPasswordConfirmation().equals(usuario.getContrasena())) {
			System.out.println("La Contraseña y su confirmacion deben ser iguales");
		} else {
			System.out.println("Usuario creado con exito");
			us.crearUsuario(usuario);
		}

		return "redirect:/login";
	}

	// ============================================
	// ==============DELETE=======================
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		System.out.println("eliminar la id:" + id);
		us.deleteUsuario(id);
		return "redirect:/usuario";
	}

	// ============================================
	// ==================EDITAR================
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("usuarioId") != null) {
			Usuario usuario = us.buscarUsuario(id);
			model.addAttribute("usuario_sesion", usuario);
			return "usuarioEditar.jsp";
		}
		return "redirect:/login";
	}

	// ============================================
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam("email") String email, @RequestParam("contrasena") String contrasena,
			HttpSession session) {
		boolean exiteUsuario = us.validarUser(email, contrasena);
		if (exiteUsuario) {
			Usuario ususario = us.findByEmail(email);
			session.setAttribute("usuarioId", ususario.getId());
			return "redirect:/carrito";
		}

		return "redirect:/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		if(session.getAttribute("usuarioId")!=null) {
			session.invalidate();//matamos todas las variables de session
		}
		return "redirect:/login";
	}
	
}