package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.entities.Usuario;

public interface UsuarioDAO extends GenericoDAO<Usuario>{

	Optional<Usuario> findByNumeroCuenta(String numeroCuenta);
	
}
