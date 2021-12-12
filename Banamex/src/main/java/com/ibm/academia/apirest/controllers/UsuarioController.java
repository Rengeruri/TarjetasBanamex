package com.ibm.academia.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.entities.Perfil;
import com.ibm.academia.apirest.entities.Usuario;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.PerfilDAO;
import com.ibm.academia.apirest.services.UsuarioDAO;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Autowired
	private PerfilDAO perfilDao;
	
	@PostMapping("/soloGuardar")
	public Usuario soloGuardarUsuario(@RequestBody Usuario usuario) {
		return usuarioDao.guardar(usuario);
	}
	
	@PostMapping
	public String guardarUsuario(@RequestBody Usuario usuario) { //Checar si se puede cambiar la implementación a una función Y checar la carga LAZY.
		String tarjetas = null;
		Optional<Perfil> perfilRecomendado = perfilDao.findByUsuario(
				usuario.getPreferencia(), 
				usuario.getSalario(), 
				usuario.getEdad());
		
		if(!perfilRecomendado.isPresent())
			usuarioDao.guardar(usuario);
		else {
			usuario.setPerfil(perfilRecomendado.get());
			tarjetas = perfilRecomendado.get().getTarjetas().toString();
			usuarioDao.guardar(usuario);
		}
		
		return tarjetas;
	}
	
	@GetMapping("/todos")
	public List<Usuario> obtenerTodos(){
		List<Usuario> usuarios = (List<Usuario>) usuarioDao.buscarTodos();
		
		if(usuarios.isEmpty())
			throw new NotFoundException("No hay usuarios");
		
		return usuarios;
	}
	
	@GetMapping("id/{id}")
	public Usuario buscarUsuario(@PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioDao.buscarPorId(id);
		
		if(!usuario.isPresent())
			throw new NotFoundException(String.format("El usuario con id %d no existe", id));
		
		return usuario.get();
	}

}
