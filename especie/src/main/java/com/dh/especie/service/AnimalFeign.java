package com.dh.especie.service;

import com.dh.especie.dto.AnimalDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ANIMAL-SERVICE")
public interface AnimalFeign {

    @GetMapping("/animal/especie/{id}")
    ResponseEntity<List<AnimalDTO>> pesquisarPorIdEspecie(@PathVariable Long id);

}
