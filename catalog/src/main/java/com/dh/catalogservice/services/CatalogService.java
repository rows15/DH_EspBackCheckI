package com.dh.catalogservice.services;

import com.dh.catalogservice.dto.MovieDTO;
import com.dh.catalogservice.interfaces.CatalogClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CatalogClient client;

    public Map<String, List<MovieDTO>> getMovies(String genre){

        return Map.of(genre,client.getMovies(genre));

    }

}
