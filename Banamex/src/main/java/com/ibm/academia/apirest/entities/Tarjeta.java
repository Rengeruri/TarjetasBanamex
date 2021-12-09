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
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tarjetas", schema = "banamex")
@Getter
@Setter
@NoArgsConstructor
public class Tarjeta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre_tarjeta")
	private String nombreTarjeta;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(
			name = "tarjeta_perfil", schema = "banamex",
			joinColumns = @JoinColumn(name = "tarjeta_id"),
			inverseJoinColumns = @JoinColumn(name = "perfil_id")
	)
	private Set<Perfil> perfiles;
	
	
	public Tarjeta(Integer id, String nombreTarjeta) {
		super();
		this.id = id;
		this.nombreTarjeta = nombreTarjeta;
	}

	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", nombreTarjeta=" + nombreTarjeta + "]";
	}

	private static final long serialVersionUID = 2911762464333103201L;

}
