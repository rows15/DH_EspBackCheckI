package com.example.movie.controller;

import com.example.movie.dto.MovieDTO;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies/")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/movies/{genre}")
    private ResponseEntity<List<MovieDTO>> pesquisarPorStringGenero(@PathVariable String genre){
        return ResponseEntity.ok(service.pesquisarPorStringGenero(genre));
    }

}
