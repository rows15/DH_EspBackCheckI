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
        entity.setNome(dto.getNome());
        entity.setIdEspecie(dto.getIdEspecie());
        return entityToDTO(repository.save(entity));
    }

    @Override
    public List<MovieDTO> pesquisarPorIdEspecie(Long id) {
        return repository.findByIdEspecie(id)
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    private MovieDTO entityToDTO(Movie movie) {
        return MovieDTO.builder()
                .id(movie.getId())
                .nome(movie.getNome())
                .idEspecie(movie.getIdEspecie())
                .build();
    }

}
