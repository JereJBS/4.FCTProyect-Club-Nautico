package com.nauticclub4.FCTProyectJPA.entities;

import java.io.Serializable;
// import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
// import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

	// DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	// Date date = new Date();
	// String dateToStr = df.format(date);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha")
	private String fechaHora;

	@Column(name = "destino", nullable = false)
	private String destino;

	@ManyToOne(fetch = FetchType.EAGER)
    private Barco barco;

	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patron", referencedColumnName = "id", nullable = false)
    private Patron patron;
}
