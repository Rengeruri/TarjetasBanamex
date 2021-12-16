package com.ibm.academia.apirest.datos;

import java.util.Set;

import com.ibm.academia.apirest.enums.Preferencia;
import com.ibm.academia.apirest.models.entities.Perfil;
import com.ibm.academia.apirest.models.entities.Tarjeta;

public class DatosDummy {
	
	public static Perfil perfil01() {
		Perfil perfil01 = new Perfil(null, Preferencia.SHOPPING, 7000.0, 14999.0, 18, 23);
		perfil01.setTarjetas(Set.of(new Tarjeta(null, "B*Smart"), new Tarjeta(null, "Afinity Card")));
		return perfil01;
	}
	
	public static Perfil perfil02() {
		Perfil perfil01 = new Perfil(null, Preferencia.SHOPPING, 15000.0, 35999.0, 24, 32);
		perfil01.setTarjetas(Set.of(new Tarjeta(null, "Clasica"), new Tarjeta(null, "Costo")));
		return perfil01;
	}

}
