package com.adriel.rural.repositories;

import com.adriel.rural.models.Especie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {
    
}
