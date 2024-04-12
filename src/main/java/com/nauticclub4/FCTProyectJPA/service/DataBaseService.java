package com.nauticclub4.FCTProyectJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nauticclub4.FCTProyectJPA.entities.Barco;
import com.nauticclub4.FCTProyectJPA.entities.Patron;
import com.nauticclub4.FCTProyectJPA.entities.Salidas;
import com.nauticclub4.FCTProyectJPA.entities.Socio;
import com.nauticclub4.FCTProyectJPA.repository.BarcoRepository;
import com.nauticclub4.FCTProyectJPA.repository.PatronRepository;
import com.nauticclub4.FCTProyectJPA.repository.SalidasRepository;
import com.nauticclub4.FCTProyectJPA.repository.SocioRepository;

@Service
public class DataBaseService {
    
    @Autowired
    BarcoRepository barcoRepository;

    @Autowired
    PatronRepository patronRepository;

    @Autowired
    SalidasRepository salidasRepository;

    @Autowired
    SocioRepository socioRepository;

    // public Barco saveBarco(Barco barco){
    //     return barcoRepository.save(barco);
    // }

    // public Patron savePatron(Patron patron){
    //     return patronRepository.save(patron);
    // }

    // public Salidas saveSalidas(Salidas salida){
    //     return salidasRepository.save(salida);
    // }

    // public Socio saveSocio(Socio socio){
    //     return socioRepository.save(socio);
    // }

    public Barco findById(Long id) {
		return barcoRepository.findById(id).get();
	}
	
	public List<Barco> findAll(){
		return barcoRepository.findAll();
	}

    public ResponseEntity<String> crearBarco(Barco barco) {
		barcoRepository.save(barco);
		return ResponseEntity.status(HttpStatus.CREATED).body("Barco creado");
	}

    public void eliminarBarco(Long id){
        barcoRepository.deleteById(id);
    }

    public Barco actualizarBarco(Long id, Barco barcoActualizado){
        Barco barco = barcoRepository.findById(id).get();

        if ((barcoActualizado.getNMatricula()!= null)) {
			barco.setNMatricula(barcoActualizado.getNMatricula());
		}
		if (!(barcoActualizado.getNombre().isEmpty() || barcoActualizado.getNombre()== null)) {
			barco.setNombre(barcoActualizado.getNombre());
		}
		if (barcoActualizado.getSocio()!= null) {
			barco.setSocio(barcoActualizado.getSocio());
		}
		if (barcoActualizado.getSalida()!= null) {
			barco.setSalida(barcoActualizado.getSalida());
		}
        return barcoRepository.save(barco);
    }

    public Barco agregarSocio(Long id_barco, Long id_socio){
        Barco barco = barcoRepository.findById(id_barco).get();
		Socio socio = socioRepository.findById(id_socio).get();
		List<Barco> barcos = socio.getBarcos();
		barcos.add(barco);
		barco.setSocio(socio);
		socio.setBarcos(barcos);
		return barcoRepository.save(barco);
    }

    public Barco agregarSalida(Long id_barco, Long id_salida){
        Barco barco = barcoRepository.findById(id_barco).get();
        Salidas salida = salidasRepository.findById(id_salida).get();
        barco.setSalida(salida);
        return barcoRepository.save(barco);
    }


    public Patron findPatronById(Long id) {
		return patronRepository.findById(id).get();
	}
	
	public List<Patron> findAllPatron(){
		return patronRepository.findAll();
	}

    public void agregarPatron(Patron patron) {
		patronRepository.save(patron);
	}
	
	public void eliminarPatron(Long id) {
		patronRepository.deleteById(id);
	}

    public Socio findSocioById(Long id) {
		return socioRepository.findById(id).get();
	}

    public List<Socio> findAllSocios(){
		return socioRepository.findAll();
	}

    public ResponseEntity<String> crearSocio(Socio socio) {
		socioRepository.save(socio);
		return ResponseEntity.status(HttpStatus.CREATED).body("Socio creado");
	}

    public void eliminarSocio(Long id) {
		socioRepository.deleteById(id);
	}

    public Salidas findSalidaById(Long id) {
		return salidasRepository.findById(id).get();
	}

	public Socio actualizarSocio(Long id, Socio socioActualizado){
        Socio socio = socioRepository.findById(id).get();
        if((socioActualizado.getNombre() != null)){
			socio.setNombre(socioActualizado.getNombre());
		}
		if((socioActualizado.getDireccion() != null)){
			socio.setDireccion(socioActualizado.getDireccion());
		}
		if((socioActualizado.getTelefono() != null)){
			socio.setTelefono(socioActualizado.getTelefono());
		}
		if((socioActualizado.getEmail() != null)){
			socio.setEmail(socioActualizado.getEmail());
		}
		return socioRepository.save(socio);
    }

    public List<Salidas> findAllSalidas(){
		return salidasRepository.findAll();
	}

    public ResponseEntity<String> crearSalida(Salidas salida) {
		salidasRepository.save(salida);
		return ResponseEntity.status(HttpStatus.CREATED).body("Salida creada");
	}

    public void eliminarSalida(Long id) {
		salidasRepository.deleteById(id);
	}

    public Patron actualizarPatron(Long id, Patron patronActualizado){
        Patron patron = patronRepository.findById(id).get();
        if((patronActualizado.getNombre() != null)){
			patron.setNombre(patronActualizado.getNombre());
		}
		if((patronActualizado.getDireccion() != null)){
			patron.setDireccion(patronActualizado.getDireccion());
		}
		if((patronActualizado.getTelefono() != null)){
			patron.setTelefono(patronActualizado.getTelefono());
		}
		if((patronActualizado.getEmail() != null)){
			patron.setEmail(patronActualizado.getEmail());
		}
		return patronRepository.save(patron);
    }

	public void agregarSalidaPatron(Long id_salida, Long id_patron) {
		Salidas salida = salidasRepository.findById(id_salida).get();
		Patron patron = patronRepository.findById(id_patron).get();
		List<Salidas> salidas = patron.getSalidas();
		salidas.add(salida);
		salida.setPatron(patron);
	}


}
