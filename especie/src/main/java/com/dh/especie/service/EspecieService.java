package com.dh.especie.service;

import com.dh.especie.dto.AnimalDTO;
import com.dh.especie.dto.EspecieDTO;

import java.util.List;

public interface EspecieService {

    EspecieDTO salvar(EspecieDTO dto);

    EspecieDTO pesquisarPorId(Long id);

    EspecieDTO pesquisarPorNome(String nome);

    List<AnimalDTO> pesquisarAnimais(String nomeEspecie);

}
