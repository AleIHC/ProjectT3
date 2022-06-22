package com.generation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.Models.Marcador;

@Repository
public interface MarcadorRepository extends JpaRepository<Marcador, Long> {

}
