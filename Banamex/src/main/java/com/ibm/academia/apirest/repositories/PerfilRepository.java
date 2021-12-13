package com.ibm.academia.apirest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Perfil;
import com.ibm.academia.apirest.enums.Preferencia;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Integer>{
	
	@Query("select p from Perfil p where p.preferencia = ?1 and p.salarioMinimo <= ?2 and (p.salarioMaximo >= ?2 or p.salarioMaximo = null) and edadMinima <= ?3 and edadMaxima >= ?3")
	Optional<Perfil> buscarPorUsuario(Preferencia preferencia, Double salario, Integer edad);
	
}
