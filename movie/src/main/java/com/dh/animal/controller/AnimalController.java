package com.dh.animal.controller;

import com.dh.animal.dto.AnimalDTO;
import com.dh.animal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @PostMapping
    private ResponseEntity<AnimalDTO> salvar(@RequestBody AnimalDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("/especie/{id}")
    private ResponseEntity<List<AnimalDTO>> pesquisarPorIdEspecie(@PathVariable Long id) {
        return ResponseEntity.ok(service.pesquisarPorIdEspecie(id));
    }

}
