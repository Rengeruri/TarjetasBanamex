package com.ibm.academia.apirest.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.academia.apirest.enums.Preferencia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfiles", schema = "banamex")
@Getter
@Setter
@NoArgsConstructor
public class Perfil implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "preferencia")
	private Preferencia preferencia;
	@Column(name = "salario_minimo")
	private Double salarioMinimo;
	@Column(name = "salario_maximo")
	private Double salarioMaximo;
	@Column(name = "edad_minima")
	private Integer edadMinima;
	@Column(name = "edad_maxima")
	private Integer edadMaxima;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(
			name = "perfil_tarjeta", schema = "banamex",
			joinColumns = @JoinColumn(name = "perfil_id"),
			inverseJoinColumns = @JoinColumn(name = "tarjeta_id")
	)
	@JsonIgnoreProperties({"perfiles", "hibernateLazyInitializer"})
	private Set<Tarjeta> tarjetas;
	
	@OneToMany(mappedBy = "perfil", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"perfil", "hibernateLazyInitializer"})
	private Set<Usuario> usuarios;
	
	public Perfil(Integer id, Preferencia preferencia, Double salarioMinimo, Double salarioMaximo,
			Integer edadMinima, Integer edadMaxima) {
		super();
		this.id = id;
		this.preferencia = preferencia;
		this.salarioMinimo = salarioMinimo;
		this.salarioMaximo = salarioMaximo;
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
	}
	
	@Override
	public String toString() {
		return "Perfil [id=" + id + ", preferencia=" + preferencia + ", salarioMinimo=" + salarioMinimo
				+ ", salarioMaximo=" + salarioMaximo + ", edadMinima=" + edadMinima + ", edadMaxima=" + edadMaxima
				+ "]";
	}



	private static final long serialVersionUID = 7766229116411394170L;
	
}
