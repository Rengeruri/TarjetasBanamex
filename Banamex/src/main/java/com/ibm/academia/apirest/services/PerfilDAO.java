package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.enums.Preferencia;
import com.ibm.academia.apirest.models.entities.Perfil;

public interface PerfilDAO extends GenericoDAO<Perfil>{
		
	public Optional<Perfil> buscarPorUsuario(Preferencia preferencia, Double salario, Integer edad);
	public Perfil actualizar(Perfil perfilEncontrado, Perfil perfil);
		
}
