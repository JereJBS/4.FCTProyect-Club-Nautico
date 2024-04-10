package com.nauticclub4.FCTProyectJPA.entities;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "Barco")
public class Barco implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nMatricula", nullable = false)
	private String nMatricula;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "nAmarre", nullable = false)
	private int nAmarre;

	@Column(name = "cuota", nullable = false)
	private float cuota;

	@ManyToOne
	@JoinColumn(name="socio_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Socio socio;
	
	@OneToOne
    @JoinColumn(name = "salida_id")
    @JsonIgnore
    private Salidas salida;
	



	// @OneToMany(fetch = FetchType.LAZY)
	// @JoinColumn(name = "socioId", nullable = false)
	// @OnDelete(action = OnDeleteAction.CASCADE)
	// @JsonIgnore
	// private Socio socio;

	// @OneToMany(fetch = FetchType.LAZY)
	// @JoinColumn(name = "patronId", nullable = false)
	// @OnDelete(action = OnDeleteAction.CASCADE)
	// @JsonIgnore
	// private Patron patron;
}
