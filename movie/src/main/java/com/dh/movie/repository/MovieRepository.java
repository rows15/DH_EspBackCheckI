package com.dh.movie.repository;

import com.dh.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByIdEspecie(Long id);

    /*List<Movie> findByStrGenre(String genre);*/
}
