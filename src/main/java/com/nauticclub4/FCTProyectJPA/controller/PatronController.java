package com.nauticclub4.FCTProyectJPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nauticclub4.FCTProyectJPA.entities.Patron;
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
	public ResponseEntity<Patron> findById(@PathVariable long idPatron) {
		return ResponseEntity.ok(dataBaseService.findPatronById(idPatron));
	}

    @PostMapping("/patrones")
	public ResponseEntity<String> postPatron(@RequestBody Patron patron){
		dataBaseService.agregarPatron(patron);
		return ResponseEntity.status(HttpStatus.CREATED).body("Creado el patron");
	}

    @DeleteMapping("/patrones/{idPatron}")
	public ResponseEntity<String> borrar(@PathVariable long idPatron) {
		dataBaseService.eliminarPatron(idPatron);
		return ResponseEntity.ok("Patron Borrado");
	}

	@PutMapping("/patrones/{idSalida}/{idPatron}")
	public ResponseEntity<String> agregarSalidaPatron(@PathVariable long idSalida, @PathVariable long idPatron){
		dataBaseService.agregarSalidaPatron(idSalida, idPatron);
		return ResponseEntity.ok("Se añadió una salida a un patron");
	}
    
}
