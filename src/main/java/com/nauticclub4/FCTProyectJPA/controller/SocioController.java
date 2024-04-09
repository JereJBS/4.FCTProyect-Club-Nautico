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

import com.nauticclub4.FCTProyectJPA.entities.Socio;
import com.nauticclub4.FCTProyectJPA.service.DataBaseService;

@RestController
@RequestMapping("/api/v1")
public class SocioController {
    
    @Autowired
    DataBaseService dataBaseService;

    @GetMapping("/socios")
	public List<Socio> getAllSocios(){
		return dataBaseService.findAllSocios();
	}

    @GetMapping("/{idSocio}")
	public ResponseEntity<Socio> findById(@PathVariable long idSocio) {
		return ResponseEntity.ok(dataBaseService.findSocioById(idSocio));
	}

    @PostMapping("/socios")
	public ResponseEntity<String> postSocio(@RequestBody Socio socio){
		return dataBaseService.crearSocio(socio);
	}

    @DeleteMapping("/{idSocio}")
	public ResponseEntity<String> borrar(@PathVariable long idSocio) {
		dataBaseService.eliminarSocio(idSocio);
		return ResponseEntity.ok("Socio borrado");
	}
}
