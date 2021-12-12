package com.ibm.academia.apirest.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.academia.apirest.enums.Preferencia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios", schema = "banamex")
@Getter
@Setter
@NoArgsConstructor
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //ID
	
	@Column(name = "numero_cuenta", unique = true)
	private String numeroCuenta;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "preferencia")
	private Preferencia preferencia;
	@Column(name = "salario")
	private Double salario;
	@Column(name = "edad")
	private Integer edad;

	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "perfil_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "usuarios"})
	private Perfil perfil;

	public Usuario(Integer id, String numeroCuenta, String nombre, String apellido, Preferencia preferencia, Double salario,
			Integer edad) {
		super();
		this.id = id;
		this.numeroCuenta = numeroCuenta;
		this.nombre = nombre;
		this.apellido = apellido;
		this.preferencia = preferencia;
		this.salario = salario;
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", numeroCuenta=" + numeroCuenta + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", preferencia=" + preferencia + ", salario=" + salario + ", edad=" + edad + "]";
	}



	private static final long serialVersionUID = -325316657359689239L;
	
}
