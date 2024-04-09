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
// import com.nauticclub4.FCTProyectJPA.repository.BarcoRepository;
// import com.nauticclub4.FCTProyectJPA.repository.PatronRepository;
// import com.nauticclub4.FCTProyectJPA.repository.SalidasRepository;
// import com.nauticclub4.FCTProyectJPA.repository.SocioRepository;
import com.nauticclub4.FCTProyectJPA.service.DataBaseService;

@RestController
@RequestMapping("/api/v1")
public class BarcoController {

    // @Autowired
    // BarcoRepository barcoRepository;

    // @Autowired
    // PatronRepository patronRepository;

    // @Autowired
    // SalidasRepository salidasRepository;

    // @Autowired
    // SocioRepository socioRepository;

    @Autowired
    DataBaseService dataBaseService;

    @GetMapping("/barcos")
	public List<Barco> allBarco(){
		return dataBaseService.findAll();
	}

    @GetMapping("/{idBarco}")
	public ResponseEntity<Barco> findById(@PathVariable long idBarco) {
		return ResponseEntity.ok(dataBaseService.findById(idBarco));
	}

    @PostMapping("/barcos")
	public ResponseEntity<String> postBarco(@RequestBody Barco barco){
		return dataBaseService.crearBarco(barco);
	}

    @DeleteMapping("/{idBarco}")
	public ResponseEntity<String> borrarBarco(@PathVariable long id) {
		dataBaseService.eliminarBarco(id);
		return ResponseEntity.ok("Borrado");
	}

    @PutMapping("/{idBarco}")
	public String modificarBarco(@PathVariable long idBarco,@RequestBody Barco barco) {
		return dataBaseService.actualizarBarco(idBarco, barco);
	}

    @PutMapping("/agregarSocio/{idBarco}/{idSocio}")
	public Barco agregarSocio(@PathVariable long idBarco , @PathVariable long idSocio) {
		return dataBaseService.agregarSocio(idBarco, idSocio);
	}

    // @GetMapping("/barcos")
    // public List<Barco> getAllBarcos(){
    //     return barcoRepository.findAll();
    // }

    // @GetMapping("/barcos/{barcoId}")
    // public Barco getBarco(@PathVariable(name = "barcoId") Long barcoId){
    //     return barcoRepository.findById(barcoId).get();
    // }

    // @PostMapping("/barcos")
    // public String addBarco(Barco barco){
    //     dataBaseService.saveBarco(barco);
    //     return "Barco creado correctamente";
    // }
}
