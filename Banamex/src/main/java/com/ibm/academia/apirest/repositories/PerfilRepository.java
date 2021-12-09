package com.ibm.academia.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Perfil;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Integer>{

}
