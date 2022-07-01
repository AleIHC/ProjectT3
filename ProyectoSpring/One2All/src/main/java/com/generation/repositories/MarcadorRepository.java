package com.generation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.models.Marcador;

@Repository
public interface MarcadorRepository extends JpaRepository<Marcador, Long> {

}
