package com.generation.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generation.Models.Marcador;

@Repository
public interface MarcadorRepository extends JpaRepository<Marcador, Long> {

    @Query(value = "Select * from marcadores where categoria_id = ?1",nativeQuery = true)
    List<Marcador> findCategoria(Integer id);
}
