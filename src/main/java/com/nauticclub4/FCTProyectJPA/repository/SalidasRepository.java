package com.nauticclub4.FCTProyectJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nauticclub4.FCTProyectJPA.entities.Salidas;

@Repository
public interface SalidasRepository extends JpaRepository<Salidas, Long>{
    
}
