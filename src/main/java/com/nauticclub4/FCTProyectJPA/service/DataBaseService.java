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

    public String eliminarBarco(Long id){
        barcoRepository.deleteById(id);
		return "Barco borrado";
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
		List<Salidas> salidas = barco.getSalida();
		salidas.add(salida);
		barco.setSalida(salidas);
		salida.setBarco(barco);
		return barcoRepository.save(barco);
    }


    public Patron findPatronById(Long id) {
		return patronRepository.findById(id).get();
	}
	
	public List<Patron> findAllPatron(){
		return patronRepository.findAll();
	}

    public String agregarPatron(Patron patron) {
		patronRepository.save(patron);
		return "Patron creado";
	}
	
	public String eliminarPatron(Long id) {
		patronRepository.deleteById(id);
		return "Patron eliminado";
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

    public String eliminarSocio(Long id) {
		socioRepository.deleteById(id);
		return "Socio eliminado";
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

    public Salidas crearSalida(Salidas salida, Long idPatron) {
		Patron patron = patronRepository.findById(idPatron).get();
		List<Salidas> salidasTotales= salidasRepository.findAll();
		salidasTotales.add(salida);
		patron.setSalidas(salidasTotales);
		return salidasRepository.save(salida);
	}

    public String eliminarSalida(Long id) {
		salidasRepository.deleteById(id);
		return "Se elimino la salida";
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

	public Salidas agregarSalidaPatron(Long id_salida, Long id_patron) {
		Salidas salida = salidasRepository.findById(id_salida).get();
		Patron patron = patronRepository.findById(id_patron).get();
		List<Salidas> salidas = patron.getSalidas();
		salidas.add(salida);
		patron.setSalidas(salidas);
		salida.setPatron(patron);
		return salidasRepository.save(salida);
	}


}
