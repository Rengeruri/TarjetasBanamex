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
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.PerfilDAO;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilDAO perfilDao;
	
	@PostMapping
	public Perfil crearPerfil(@RequestBody Perfil perfil) {
		return perfilDao.guardar(perfil);
	}
	
	@GetMapping("/todos")
	public List<Perfil> obtenerTodos(){
		List<Perfil> perfiles = (List<Perfil>) perfilDao.buscarTodos();
		
		if(perfiles.isEmpty())
			throw new NotFoundException("No hay perfiles");
		
		return perfiles;
	}
	
	@GetMapping("/id/{id}")
	public Perfil buscarPerfil(@PathVariable Integer id) {
		Optional<Perfil> perfil = perfilDao.buscarPorId(id);
		
		if(!perfil.isPresent())
			throw new NotFoundException(String.format("El perfil con el id %d no existe", id));
		
		return perfil.get();
	}

}
