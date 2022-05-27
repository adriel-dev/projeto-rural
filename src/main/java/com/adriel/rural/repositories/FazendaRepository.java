package com.adriel.rural.repositories;

import com.adriel.rural.models.Fazenda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
    
}