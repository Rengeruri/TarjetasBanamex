package com.ibm.academia.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.entities.Perfil;
import com.ibm.academia.apirest.entities.Tarjeta;
import com.ibm.academia.apirest.enums.Preferencia;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.PerfilDAO;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilDAO perfilDao;
	
	@PostMapping
	public ResponseEntity<?> crearPerfil(@RequestBody Perfil perfil) {
		return new ResponseEntity<Perfil>(perfilDao.guardar(perfil), HttpStatus.CREATED);
	}
	
	@GetMapping("/todos")
	public ResponseEntity<?> obtenerTodos(){
		List<Perfil> perfiles = (List<Perfil>) perfilDao.buscarTodos();
		
		if(perfiles.isEmpty())
			throw new NotFoundException("No hay perfiles");
		
		return new ResponseEntity<List<Perfil>>(perfiles, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> buscarPerfil(@PathVariable Integer id) {
		Optional<Perfil> perfil = perfilDao.buscarPorId(id);
		
		if(!perfil.isPresent())
			throw new NotFoundException(String.format("El perfil con el id %d no existe", id));
		
		return new ResponseEntity<Perfil>(perfil.get(), HttpStatus.OK);
	}
	
	@GetMapping("/detalle/usuario")
	public ResponseEntity<?> recomendarTarjeta(@RequestParam String preferencia, @RequestParam Integer edad, @RequestParam Double salario) {
		Preferencia preferenciaEnum = Preferencia.valueOf(preferencia.toUpperCase());
		Optional<Perfil> oPerfil = perfilDao.buscarPorUsuario(preferenciaEnum, salario, edad);
		
		if(!oPerfil.isPresent())
			throw new NotFoundException("No se recomienda ningúna tarjeta debido al perfil");

		return new ResponseEntity<Iterable<Tarjeta>>(oPerfil.get().getTarjetas(), HttpStatus.OK);
	}

}
