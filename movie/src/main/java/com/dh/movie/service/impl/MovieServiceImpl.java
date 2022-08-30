package com.dh.movie.service.impl;

import com.dh.movie.dto.MovieDTO;
import com.dh.movie.entity.Movie;
import com.dh.movie.repository.MovieRepository;

import com.dh.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;


    @Override
    public MovieDTO salvar(MovieDTO dto) {
        Movie entity = new Movie();
        entity.setName(dto.getName());
        entity.setUrlStream(dto.getUrlStream());
        entity.setGenre(dto.getGenre());
        return entityToDTO(repository.save(entity));
    }




    @Override
    public List<MovieDTO> pesquisarPorGenero(String genre) {
        return repository.findByGenre(genre)
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }




    private MovieDTO entityToDTO(Movie movie) {
        return MovieDTO.builder()
                .id(movie.getId())
                .name(movie.getName())
                .urlStream(movie.getUrlStream())
                .genre((movie.getGenre()))
                .build();
    }

}
