package com.dh.especie.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class EspecieDTO implements Serializable {

    private Long id;
    private String nomeEspecie;

}
