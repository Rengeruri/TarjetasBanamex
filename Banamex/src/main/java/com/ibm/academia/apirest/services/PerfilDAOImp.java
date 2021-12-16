package com.ibm.academia.apirest.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.enums.Preferencia;
import com.ibm.academia.apirest.models.entities.Perfil;
import com.ibm.academia.apirest.repositories.PerfilRepository;

@Service
public class PerfilDAOImp extends GenericoDAOImp<Perfil, PerfilRepository> implements PerfilDAO{

	@Autowired
	public PerfilDAOImp(PerfilRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Perfil> buscarPorUsuario(Preferencia preferencia, Double salario, Integer edad) {
		return repository.buscarPorUsuario(preferencia, salario, edad);
	}

	@Override
	public Perfil actualizar(Perfil perfilEncontrado, Perfil perfil) {
		Perfil perfilActualizado = null;
		perfilEncontrado.setTarjetas(perfil.getTarjetas());
		perfilActualizado = repository.save(perfilEncontrado);
		return perfilActualizado;
	}

}
