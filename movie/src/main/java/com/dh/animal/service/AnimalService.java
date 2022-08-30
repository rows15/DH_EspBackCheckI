package com.dh.animal.service;

import com.dh.animal.dto.AnimalDTO;

import java.util.List;

public interface AnimalService {

    AnimalDTO salvar(AnimalDTO dto);

    List<AnimalDTO> pesquisarPorIdEspecie(Long id);

}
