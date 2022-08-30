package com.dh.especie.controller;

import com.dh.especie.dto.AnimalDTO;
import com.dh.especie.dto.EspecieDTO;
import com.dh.especie.service.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EspecieController {

    @Autowired
    private EspecieService service;

    @PostMapping
    private ResponseEntity<EspecieDTO> salvar(@RequestBody EspecieDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("/{id}")
    private ResponseEntity<EspecieDTO> pesquisarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.pesquisarPorId(id));
    }

    @GetMapping("/nome/{nome}")
    private ResponseEntity<EspecieDTO> pesquisarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(service.pesquisarPorNome(nome));
    }

    @GetMapping("/animal/{nomeEspecie}")
    private ResponseEntity<List<AnimalDTO>> pesquisarAnimaisPorEspecie(@PathVariable String nomeEspecie) {
        return ResponseEntity.ok(service.pesquisarAnimais(nomeEspecie));
    }

}
