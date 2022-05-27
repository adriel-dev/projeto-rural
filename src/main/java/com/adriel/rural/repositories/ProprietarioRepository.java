package com.adriel.rural.repositories;

import com.adriel.rural.models.Proprietario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {
    
}