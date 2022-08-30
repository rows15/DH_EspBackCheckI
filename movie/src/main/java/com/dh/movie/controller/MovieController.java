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


    @RequestMapping(value="/{genre}", method=RequestMethod.GET)
    private ResponseEntity<List<MovieDTO>> pesquisarPorGenero(@PathVariable ("genre") String genre) {
        return ResponseEntity.ok(service.pesquisarPorGenero(genre));
    }

}
