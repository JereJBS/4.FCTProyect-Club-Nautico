package com.nauticclub4.FCTProyectJPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nauticclub4.FCTProyectJPA.entities.Salidas;
import com.nauticclub4.FCTProyectJPA.service.DataBaseService;

@RestController
@RequestMapping("/api/v1")
public class SalidasController {
    
    @Autowired
    DataBaseService dataBaseService;

    @GetMapping("/salidas")
	public List<Salidas> allBarco(){
		return dataBaseService.findAllSalidas();
	}

    @GetMapping("/salidas/{idSalida}")
	public Salidas findById(@PathVariable long idBarco) {
		return dataBaseService.findSalidaById(idBarco);
	}

    @PostMapping("/Crearsalidas")
	public Salidas postSalida(@RequestBody Salidas salida, Long idPatron){
		return dataBaseService.crearSalida(salida, idPatron);
	}

    @DeleteMapping("/salidas/{idSalida}")
	public String borrar(@PathVariable long idSalida) {
		return dataBaseService.eliminarSalida(idSalida);
	}
}
