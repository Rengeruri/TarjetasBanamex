package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.entities.Tarjeta;

public interface TarjetaDAO extends GenericoDAO<Tarjeta>{
	
	Optional<Tarjeta> buscarPorNombre(String nombre);

}
