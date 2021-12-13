package com.ibm.academia.apirest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.entities.Tarjeta;
import com.ibm.academia.apirest.repositories.TarjetaRepository;

@Service
public class TarjetaDAOImp extends GenericoDAOImp<Tarjeta, TarjetaRepository> implements TarjetaDAO{

	@Autowired
	public TarjetaDAOImp(TarjetaRepository repository) {
		super(repository);
	}

	@Override
	public Optional<Tarjeta> buscarPorNombre(String nombre) {
		return repository.buscarPorNombre(nombre);
	}

}
