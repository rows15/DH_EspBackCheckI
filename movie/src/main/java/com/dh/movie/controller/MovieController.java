package com.dh.movie.controller;

import com.dh.movie.dto.MovieDTO;

import com.dh.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping
    private ResponseEntity<MovieDTO> salvar(@RequestBody MovieDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("/especie/{id}")
    private ResponseEntity<List<MovieDTO>> pesquisarPorIdEspecie(@PathVariable Long id) {
        return ResponseEntity.ok(service.pesquisarPorIdEspecie(id));
    }

  /*  @RequestMapping(value="/{genre}", method=RequestMethod.GET)
    private ResponseEntity<List<MovieDTO>> pesquisarPorStrGenero(@PathVariable ("genre") String genre) {
        return ResponseEntity.ok(service.pesquisarPorStrGenero(genre));
    }*/

}
