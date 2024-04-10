package com.nauticclub4.FCTProyectJPA.entities;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "Salida")
public class Salidas implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// @ManyToOne(fetch = FetchType.LAZY, optional = false)
	// @JoinColumn(name = "barco_id", nullable = false)
	// @JsonIgnore
	// Barco barco;

	@Column(name = "fecha", nullable = false)
	private Date fechaHora;

	@Column(name = "destino", nullable = false)
	private String destino;

	@OneToOne(mappedBy = "salida", fetch = FetchType.EAGER)
    private Barco barco;

	@JsonIgnore
    @OneToOne
    @JoinColumn(name = "patron", nullable = false)
    private Patron patron;
}
