package com.ibm.academia.apirest.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.enums.Preferencia;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.mapper.TarjetaMapper;
import com.ibm.academia.apirest.models.dto.TarjetaDTO;
import com.ibm.academia.apirest.models.entities.Perfil;
import com.ibm.academia.apirest.models.entities.Tarjeta;
import com.ibm.academia.apirest.services.PerfilDAO;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilDAO perfilDao;
	
	/**
	 * Endpoint para crear un perfil
	 * @param perfil: Perfil que se quiere guardar
	 * @return Regresa el perfil guardado
	 * @author CUVH - 15/12/2021
	 */
	@PostMapping
	public ResponseEntity<?> crearPerfil(@RequestBody Perfil perfil) {
		return new ResponseEntity<Perfil>(perfilDao.guardar(perfil), HttpStatus.CREATED);
	}
	
	/**
	 * Endpoint que actualiza las tarjetas de un perfil ya guardado
	 * @param id: Para identificar el perfil que se quiere actualizar
	 * @param perfil: El perfil actualizado
	 * @return Retorna un perfil actualizado
	 * @NotFoundException En caso de no encontrar al perfil
	 * @author CUVH - 15/12/2021
	 */
	@PutMapping("/upd/id/{id}")
	public ResponseEntity<?> actualizarPerfil(@PathVariable Integer id, @RequestBody Perfil perfil){
		Optional<Perfil> oPerfil = perfilDao.buscarPorId(id);
		
		if(!oPerfil.isPresent())
			throw new NotFoundException(String.format("El perfil con id %d no existe", id));
		
		Perfil perfilActualizado = perfilDao.actualizar(oPerfil.get(), perfil);
		
		return new ResponseEntity<Perfil>(perfilActualizado, HttpStatus.OK);
	}
	
	/**
	 * Endpoint para obtener todos los perfiles
	 * @return Regresa una lista de todos los perfiles que existen
	 * @NotFoundException En caso de no encontrar ningun perfil
	 * @author CUVH - 15/12/2021
	 */
	@GetMapping("/todos")
	public ResponseEntity<?> obtenerTodos(){
		List<Perfil> perfiles = (List<Perfil>) perfilDao.buscarTodos();
		
		if(perfiles.isEmpty())
			throw new NotFoundException("No hay perfiles");
		
		return new ResponseEntity<List<Perfil>>(perfiles, HttpStatus.OK);
	}
	
	/**
	 * Endpoint para buscar un perfil por id
	 * @param id Parametro utilizado para buscar el perfil
	 * @return Regresa el perfil encontrado
	 * @NotFoundException En caso de no encontrar ningún perfil
	 * @author CUVH - 15/12/2021
	 */
	@GetMapping("/id/{id}")
	public ResponseEntity<?> buscarPerfil(@PathVariable Integer id) {
		Optional<Perfil> perfil = perfilDao.buscarPorId(id);
		
		if(!perfil.isPresent())
			throw new NotFoundException(String.format("El perfil con el id %d no existe", id));
		
		return new ResponseEntity<Perfil>(perfil.get(), HttpStatus.OK);
	}
	
	/**
	 * Endpoint para recomendar tarjetas al usuario con información de los perfiles a los que pertenecen
	 * @param preferencia La preferencia del usuario (ENUM)
	 * @param edad La edad del usuario (Integer)
	 * @param salario El salario del usuario (Double)
	 * @return Regresa las tarjetas que son recomendadas al usuario
	 * @NotFoundException En caso de no encontrar ningún perfil acorde al usuario ingresado
	 * @author CUVH - 15/12/2021
	 */
	@GetMapping("/detalle/usuario")
	public ResponseEntity<?> recomendarTarjetaDetalle(@RequestParam String preferencia, @RequestParam Integer edad, @RequestParam Double salario) {
		Preferencia preferenciaEnum = Preferencia.valueOf(preferencia.toUpperCase());
		Optional<Perfil> oPerfil = perfilDao.buscarPorUsuario(preferenciaEnum, salario, edad);
		
		if(!oPerfil.isPresent())
			throw new NotFoundException("No se recomienda ningúna tarjeta debido al perfil");

		return new ResponseEntity<Iterable<Tarjeta>>(oPerfil.get().getTarjetas(), HttpStatus.OK);
	}
	
	/**
	 * Endpoint para recomendar tarjetas al usuario
	 * @param preferencia La preferencia del usuario (ENUM)
	 * @param edad La edad del usuario (Integer)
	 * @param salario El salario del usuario (Double)
	 * @return Regresa solo el nombre de las tarjetas recomendadas
	 * @NotFoundException En caso de no encontrar ningún perfil acorde al usuario ingresado
	 * @author CUVH - 15/12/2021
	 */
	@GetMapping("/usuario")
	public ResponseEntity<?> recomendarTarjeta(@RequestParam String preferencia, @RequestParam Integer edad, @RequestParam Double salario){
		Preferencia preferenciaEnum = Preferencia.valueOf(preferencia.toUpperCase());
		Optional<Perfil> oPerfil = perfilDao.buscarPorUsuario(preferenciaEnum, salario, edad);
		
		if(!oPerfil.isPresent())
			throw new NotFoundException("No se recomienda ningúna tarjeta debido al perfil");
		
		Iterable<TarjetaDTO> listaTarjetas = oPerfil.get().getTarjetas()
				.stream()
				.map(TarjetaMapper::mapTarjeta)
				.collect(Collectors.toList());
		
		return new ResponseEntity<Iterable<TarjetaDTO>>(listaTarjetas, HttpStatus.OK);
	}

}
