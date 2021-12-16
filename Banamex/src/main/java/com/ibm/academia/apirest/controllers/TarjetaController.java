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

import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.models.entities.Tarjeta;
import com.ibm.academia.apirest.services.TarjetaDAO;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {
	
	@Autowired
	private TarjetaDAO tarjetaDao;
	
	/**
	 * Endpoint para crear un objeto tarjeta
	 * @param tarjeta Contiene el objeto a guardar
	 * @return Regresa la tarjeta guardada
	 * @author CUVH - 15/12/2021
	 */
	@PostMapping
	public ResponseEntity<?> crearTarjeta(@RequestBody Tarjeta tarjeta) {
		return new ResponseEntity<Tarjeta>(tarjetaDao.guardar(tarjeta), HttpStatus.CREATED);
	}
	
	/**
	 * Endpoint para obtener todas las tarjetas
	 * @return Regresa una lista de todas las tarjetas
	 * @NotFoundException En caso de no encontrar ninguna tarjeta
	 * @author CUVH - 15/12/2021
	 */
	@GetMapping("/todos")
	public ResponseEntity<?> obtenerTodos(){
		List<Tarjeta> tarjetas = (List<Tarjeta>) tarjetaDao.buscarTodos();
		
		if(tarjetas.isEmpty())
			throw new NotFoundException("No hay tarjetas");
		
		return new ResponseEntity<List<Tarjeta>>(tarjetas, HttpStatus.OK);
	}
	
	/**
	 * Endpoint para buscar una tarjeta por id
	 * @param id Parametro para encontrar la tarjeta
	 * @return Regresa la tarjeta encontrada
	 * @NotFoundException En caso de no encontrar ninguna tarjeta
	 * @author CUVH - 15/12/2021
	 */
	@GetMapping("/id/{id}")
	public ResponseEntity<?> buscarTarjeta(@PathVariable Integer id) {
		Optional<Tarjeta> tarjeta = tarjetaDao.buscarPorId(id);
		
		if(!tarjeta.isPresent())
			throw new NotFoundException(String.format("La tarjeta con el id %d no existe", id));
		
		return new ResponseEntity<Tarjeta>(tarjeta.get(), HttpStatus.OK);
	}

}
