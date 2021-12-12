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
import com.ibm.academia.apirest.entities.Tarjeta;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.TarjetaDAO;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {
	
	@Autowired
	private TarjetaDAO tarjetaDao;
	
	@PostMapping
	public Tarjeta crearTarjeta(@RequestBody Tarjeta tarjeta) {
		return tarjetaDao.guardar(tarjeta);
	}
	
	@GetMapping("/todos")
	public List<Tarjeta> obtenerTodos(){
		List<Tarjeta> tarjetas = (List<Tarjeta>) tarjetaDao.buscarTodos();
		
		if(tarjetas.isEmpty())
			throw new NotFoundException("No hay tarjetas");
		
		return tarjetas;
	}
	
	@GetMapping("/id/{id}")
	public Tarjeta buscarTarjeta(@PathVariable Integer id) {
		Optional<Tarjeta> tarjeta = tarjetaDao.buscarPorId(id);
		
		if(!tarjeta.isPresent())
			throw new NotFoundException(String.format("La tarjeta con el id %d no existe", id));
		
		return tarjeta.get();
	}

}
