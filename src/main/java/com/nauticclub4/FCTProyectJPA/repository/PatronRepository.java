package com.nauticclub4.FCTProyectJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nauticclub4.FCTProyectJPA.entities.Patron;

public interface PatronRepository extends JpaRepository<Patron, Long>{
    
}
