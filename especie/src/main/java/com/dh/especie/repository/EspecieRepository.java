package com.dh.especie.repository;

import com.dh.especie.entity.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {

    Optional<Especie> findByNomeEspecie(String nomeEspecie);

}
