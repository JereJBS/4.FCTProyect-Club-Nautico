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

    public String actualizarBarco(Long id, Barco barcoActualizado){
        Barco barco = barcoRepository.findById(id).get();
        StringBuilder nuevosDatos = new StringBuilder();
        if ((barcoActualizado.getNMatricula()!= null)) {
			barco.setNMatricula(barcoActualizado.getNMatricula());
			nuevosDatos.append("modificado numero de Matricula ");
			System.out.println("1");
		}
		if (!(barcoActualizado.getNombre().isEmpty() || barcoActualizado.getNombre()== null)) {
			barco.setNombre(barcoActualizado.getNombre());
			nuevosDatos.append("nombre modificado ");
			System.out.println("2");
		}
		if (barcoActualizado.getSocio()!= null) {
			barco.setSocio(barcoActualizado.getSocio());
			nuevosDatos.append("socio modificado,");
			System.out.println("3");
		}
		if (barcoActualizado.getSalida()!= null) {
			barco.setSalida(barcoActualizado.getSalida());
			nuevosDatos.append("salida modificada ");
			System.out.println("4");
		}

        barcoRepository.save(barco);
        return nuevosDatos.toString();
    }

    public Barco agregarSocio(Long id_barco, Long id_socio){
        Barco barco = barcoRepository.findById(id_barco).get();
		Socio socio = socioRepository.findById(id_socio).get();
		barco.setSocio(socio);
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

    // public String actualizarPatron(Long id, Barco patronActualizado){
    //     Patron patron = patronRepository.findById(id).get();
    //     StringBuilder nuevosDatos = new StringBuilder();
    //     //nombre, direccion, telefono, email, salida
    //     if(())
    // }


}
