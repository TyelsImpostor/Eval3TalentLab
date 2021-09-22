package com.everis.data.services;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Usuario;
import com.everis.data.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository ur;

	public List<Usuario> findAll() {
		return ur.findAll();
	}

	public void crearUsuario(@Valid Usuario usuario) {
        String hashed = BCrypt.hashpw(usuario.getContrasena(), BCrypt.gensalt());
        usuario.setContrasena(hashed);
		ur.save(usuario);
	}

	public void deleteUsuario(Long id) {
		ur.deleteById(id);
	}

	public Usuario buscarUsuario(Long id) {
		Optional<Usuario> oUsuario= ur.findById(id);
		if (oUsuario.isPresent()) {
			return oUsuario.get();
		}
		return null;
	}

	public boolean validarUser(String email, String contrasena) {
		
		Usuario usuario = ur.findByEmail(email);
		if(usuario == null) {
			return false;
		}else {
			//comparar los password
			if (BCrypt.checkpw(contrasena, usuario.getContrasena())) {
			    System.out.println("Password iguales");
				return true;
				
			}else {
			    System.out.println("Password Distintos");
			    return false;
			}
			
		}
	}
	
	public Usuario findByEmail(String email) {
		return ur.findByEmail(email);
	}


}

