package com.ibm.academia.apirest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Tarjeta;

@Repository
public interface TarjetaRepository extends CrudRepository<Tarjeta, Integer>{
	
	@Query("select t from Tarjeta t where t.nombreTarjeta = ?1")
	Optional<Tarjeta> buscarPorNombre(String nombre);

}
