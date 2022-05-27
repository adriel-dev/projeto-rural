package com.adriel.rural.repositories;

import com.adriel.rural.models.Raca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Long> {
    
}