package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.enums.Preferencia;
import com.ibm.academia.apirest.models.entities.Perfil;


@DataJpaTest
public class PerfilRepositoryTest {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@BeforeEach
	void setUp() {
		perfilRepository.save(DatosDummy.perfil01());
		perfilRepository.save(DatosDummy.perfil02());
	}
	
	@AfterEach
	void tearDown() {
		perfilRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Busar perfil por usuario")
	void buscarPorUsuario() {
		//Given
			//setUp()
		
		//Where
		Optional<Perfil> expected = perfilRepository.buscarPorUsuario(Preferencia.SHOPPING, 12000.0, 22);
		
		//Then
		assertThat(expected.get()).isInstanceOf(Perfil.class);
	}

}
