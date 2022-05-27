package com.adriel.rural.repositories;

import com.adriel.rural.models.Acompanhamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento, Long> {
    
}