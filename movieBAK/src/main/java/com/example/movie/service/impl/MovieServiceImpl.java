package com.example.movie.service.impl;


import com.example.movie.dto.MovieDTO;
import com.example.movie.entity.Movie;
import com.example.movie.repository.MovieRepository;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    @Override
    public List<MovieDTO> pesquisarPorStringGenero(String genre) {
        return repository.findByStringGenre(genre)
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    private MovieDTO entityToDTO(Movie movie){
    return MovieDTO.builder()
            .id(movie.getId())
            .name(movie.getName())
            .genre(movie.getGenre())
            .urlStream(movie.getUrlStream())
            .build();


    }
}
