package com.ibm.academia.apirest.mapper;

import com.ibm.academia.apirest.models.dto.TarjetaDTO;
import com.ibm.academia.apirest.models.entities.Tarjeta;

public class TarjetaMapper {
	
	public static TarjetaDTO mapTarjeta(Tarjeta tarjeta) {
		TarjetaDTO tarjetaDTO = new TarjetaDTO();
		tarjetaDTO.setNombreTarjeta(tarjeta.getNombreTarjeta());
		return tarjetaDTO;
	}

}
