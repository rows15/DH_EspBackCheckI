package com.dh.movie.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class MovieDTO implements Serializable {

    private Long id;
    private String name;
    private String urlStream;
    private String genre;
}
