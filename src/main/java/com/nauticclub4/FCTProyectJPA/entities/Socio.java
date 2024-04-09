package com.nauticclub4.FCTProyectJPA.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "socio")
public class Socio implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name = "nombre", nullable = false)
	private String name;

	@Column(name = "direccion", nullable = false)
	private String direccion;

	@Column(name = "telefono", nullable = false)
	private String telefono;

	@Column(name = "email", nullable = false)
	private String email;

	// @JsonIgnore
	// @OneToMany(mappedBy="socio", cascade=CascadeType.ALL, orphanRemoval=true)
	// private List<Barco> barcos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Barco> barcos;

}
