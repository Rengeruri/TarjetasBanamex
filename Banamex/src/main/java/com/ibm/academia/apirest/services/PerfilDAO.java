package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.entities.Perfil;
import com.ibm.academia.apirest.enums.Preferencia;

public interface PerfilDAO extends GenericoDAO<Perfil>{
		
	Optional<Perfil> buscarPorUsuario(Preferencia preferencia, Double salario, Integer edad);
		
}
