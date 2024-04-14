package com.nauticclub4.FCTProyectJPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nauticclub4.FCTProyectJPA.entities.Barco;

import com.nauticclub4.FCTProyectJPA.service.DataBaseService;

@RestController
@RequestMapping("/api/v1")
public class BarcoController {

    @Autowired
    DataBaseService dataBaseService;

    @GetMapping("/barcos")
	public List<Barco> allBarco(){
		return dataBaseService.findAll();
	}

    @GetMapping("/barcos/{idBarco}")
	public Barco findById(@PathVariable long idBarco) {
		return dataBaseService.findById(idBarco);
	}

    @PostMapping("/barcos")
	public ResponseEntity<String> postBarco(@RequestBody Barco barco){
		return dataBaseService.crearBarco(barco);
	}

    @DeleteMapping("/barcos/{idBarco}")
	public String borrarBarco(@PathVariable long id) {
		return dataBaseService.eliminarBarco(id);
	}

    @PutMapping("/barcos/{idBarco}")
	public Barco modificarBarco(@PathVariable long idBarco,@RequestBody Barco barco) {
		return dataBaseService.actualizarBarco(idBarco, barco);
	}

    @PutMapping("/agregarSocio/{idBarco}/{idSocio}")
	public Barco agregarSocio(@PathVariable long idBarco , @PathVariable long idSocio) {
		return dataBaseService.agregarSocio(idBarco, idSocio);
	}

    @PutMapping("/agregarSalida/{idBarco}/{idSalida}")
	public Barco agregarSalida(@PathVariable long idBarco , @PathVariable long idSalida) {
		return dataBaseService.agregarSalida(idBarco, idSalida);
	}
}
