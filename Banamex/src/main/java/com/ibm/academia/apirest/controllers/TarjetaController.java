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
import org.springframework.web.bind.annotation.RestController;
import com.ibm.academia.apirest.entities.Tarjeta;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.TarjetaDAO;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {
	
	@Autowired
	private TarjetaDAO tarjetaDao;
	
	@PostMapping
	public ResponseEntity<?> crearTarjeta(@RequestBody Tarjeta tarjeta) {
		return new ResponseEntity<Tarjeta>(tarjetaDao.guardar(tarjeta), HttpStatus.CREATED);
	}
	
	@GetMapping("/todos")
	public ResponseEntity<?> obtenerTodos(){
		List<Tarjeta> tarjetas = (List<Tarjeta>) tarjetaDao.buscarTodos();
		
		if(tarjetas.isEmpty())
			throw new NotFoundException("No hay tarjetas");
		
		return new ResponseEntity<List<Tarjeta>>(tarjetas, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> buscarTarjeta(@PathVariable Integer id) {
		Optional<Tarjeta> tarjeta = tarjetaDao.buscarPorId(id);
		
		if(!tarjeta.isPresent())
			throw new NotFoundException(String.format("La tarjeta con el id %d no existe", id));
		
		return new ResponseEntity<Tarjeta>(tarjeta.get(), HttpStatus.OK);
	}
	
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<?> buscarTarjetaNombre(@PathVariable String nombre){
		Optional<Tarjeta> oTarjeta = tarjetaDao.buscarPorNombre(nombre);
		
		if(!oTarjeta.isPresent())
			throw new NotFoundException(String.format("No existe tarjeta con nombre %d", nombre));
		
		return new ResponseEntity<Tarjeta>(oTarjeta.get(), HttpStatus.OK);
	}

}
