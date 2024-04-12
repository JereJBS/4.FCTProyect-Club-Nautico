package com.nauticclub4.FCTProyectJPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Salidas> findById(@PathVariable long idBarco) {
		return ResponseEntity.ok(dataBaseService.findSalidaById(idBarco));
	}

    @PostMapping("/salidas")
	public ResponseEntity<String> postBarco(@RequestBody Salidas salida){
		return dataBaseService.crearSalida(salida);
	}

    @DeleteMapping("/salidas/{idSalida}")
	public ResponseEntity<String> borrar(@PathVariable long idSalida) {
		dataBaseService.eliminarSalida(idSalida);
		return ResponseEntity.ok("Salida borrada");
	}
}
