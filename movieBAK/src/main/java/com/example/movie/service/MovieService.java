package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {


    List<MovieDTO> pesquisarPorStringGenero(String genre);
}
