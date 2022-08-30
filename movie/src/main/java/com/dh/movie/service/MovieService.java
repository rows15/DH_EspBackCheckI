package com.dh.movie.service;

import com.dh.movie.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO salvar(MovieDTO dto);




    List<MovieDTO> pesquisarPorGenero(String genre);



}
