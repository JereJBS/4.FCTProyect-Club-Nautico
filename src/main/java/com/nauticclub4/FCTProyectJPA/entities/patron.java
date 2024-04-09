package com.nauticclub4.FCTProyectJPA.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "patron")
public class Patron {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "direccion", nullable = false)
	private String direccion;

	@Column(name = "telefono", nullable = false)
	private String telefono;

	@Column(name = "email", nullable = false)
	private String email;

	@JsonIgnore
    @OneToOne(mappedBy = "patron")
    private Salidas salida;
}
