package com.soulcode.projetofinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.soulcode.projetofinal.models.Financeiro;

@Repository
public interface FiltroRepository extends JpaRepository <Financeiro, Integer>{
    
} 