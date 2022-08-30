package com.dh.especie.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AnimalDTO implements Serializable {

    private Long id;
    private String nome;
    private Long idEspecie;

}
