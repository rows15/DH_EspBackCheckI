package com.example.movie.repository;

import com.example.movie.entity.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String>{

    List<Movie> findByStringGenre(String genre);
}
