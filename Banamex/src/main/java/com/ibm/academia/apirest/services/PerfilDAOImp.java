package com.ibm.academia.apirest.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.entities.Perfil;
import com.ibm.academia.apirest.enums.Preferencia;
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

}
