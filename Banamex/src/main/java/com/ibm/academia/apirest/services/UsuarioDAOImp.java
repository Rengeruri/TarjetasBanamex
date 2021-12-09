package com.ibm.academia.apirest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.entities.Usuario;
import com.ibm.academia.apirest.repositories.UsuarioRepository;

@Service
public class UsuarioDAOImp extends GenericoDAOImp<Usuario, UsuarioRepository> implements UsuarioDAO{

	@Autowired
	public UsuarioDAOImp(UsuarioRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findByNumeroCuenta(String numeroCuenta) {
		return repository.findByNumeroCuenta(numeroCuenta);
	}

}
