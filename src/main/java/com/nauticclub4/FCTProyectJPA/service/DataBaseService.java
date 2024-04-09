package com.nauticclub4.FCTProyectJPA.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Barco saveBarco(Barco barco){
        return barcoRepository.save(barco);
    }

    public Patron savePatron(Patron patron){
        return patronRepository.save(patron);
    }

    public Salidas saveSalidas(Salidas salida){
        return salidasRepository.save(salida);
    }

    public Socio saveSocio(Socio socio){
        return socioRepository.save(socio);
    }
}
