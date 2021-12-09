package com.ibm.academia.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ibm.academia.apirest.entities.Tarjeta;
import com.ibm.academia.apirest.services.TarjetaDAO;

@SpringBootApplication
public class BanamexApplication implements CommandLineRunner{
	
	/*@Autowired
	private PerfilDAO perfilDao;*/
	
	@Autowired
	private TarjetaDAO tarjetaDao;
	
	public static void main(String[] args) {
		SpringApplication.run(BanamexApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Usuario usuario = new Usuario(null, "018009998080", "Uriel", "Villegas", "Shopping", 30000.0, 23);
		usuarioDao.save(usuario);
		
		Optional<Usuario> usuario = usuarioDao.findByNumeroCuenta("018009998080");
		System.out.println(usuario.get().toString());*/
		
		/*Perfil perfil1 = new Perfil(null, Preferencia.SHOPPING, 7000.0, 14999.0, 18, 23);
		perfilDao.save(perfil1);*/
		
		Tarjeta tarjeta = new Tarjeta(null, "B*Smart");
		tarjetaDao.save(tarjeta);
		
	}
}
