package com.nauticclub4.FCTProyectJPA.entities;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "Salida")
public class Salidas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// @ManyToOne(fetch = FetchType.LAZY, optional = false)
	// @JoinColumn(name = "barco_id", nullable = false)
	// @JsonIgnore
	// Barco barco;

	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@Column(name = "destino", nullable = false)
	private String destino;
}
