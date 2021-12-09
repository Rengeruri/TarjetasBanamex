package com.ibm.academia.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.entities.Perfil;
import com.ibm.academia.apirest.repositories.PerfilRepository;

@Service
public class PerfilDAOImp extends GenericoDAOImp<Perfil, PerfilRepository> implements PerfilDAO{

	@Autowired
	public PerfilDAOImp(PerfilRepository repository) {
		super(repository);
	}

}
