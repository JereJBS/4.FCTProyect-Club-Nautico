package com.nauticclub4.FCTProyectJPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nauticclub4.FCTProyectJPA.entities.Patron;
import com.nauticclub4.FCTProyectJPA.entities.Salidas;
import com.nauticclub4.FCTProyectJPA.service.DataBaseService;

@RestController
@RequestMapping("/api/v1")
public class PatronController {
    
    @Autowired
    DataBaseService dataBaseService;

    @GetMapping("/patrones")
	public List<Patron> allPatron(){
		return dataBaseService.findAllPatron();
	}

    @GetMapping("/patrones/{idPatron}")
	public Patron findById(@PathVariable long idPatron) {
		return dataBaseService.findPatronById(idPatron);
	}

    @PostMapping("/patrones")
	public String postPatron(@RequestBody Patron patron){
		return dataBaseService.agregarPatron(patron);
	}

    @DeleteMapping("/patrones/{idPatron}")
	public String borrar(@PathVariable long idPatron) {
		return dataBaseService.eliminarPatron(idPatron);
	}

	//Not found
	@PutMapping("/patrones/{idSalida}/{idPatron}")
	public  Salidas agregarSalidaPatron(@PathVariable long idSalida, @PathVariable long idPatron){
		return dataBaseService.agregarSalidaPatron(idSalida, idPatron);
	}
    
}
