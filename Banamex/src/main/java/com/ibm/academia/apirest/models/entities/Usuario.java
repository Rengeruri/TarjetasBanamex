package com.ibm.academia.apirest.models.entities;

import java.io.Serializable;

import com.ibm.academia.apirest.enums.Preferencia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario implements Serializable{ //TODO: Si no le encuentro una implementación, se eliminará esta clase

	private Preferencia preferencia;
	private Double salario;
	private Integer edad;

	private static final long serialVersionUID = -325316657359689239L;
	
}
