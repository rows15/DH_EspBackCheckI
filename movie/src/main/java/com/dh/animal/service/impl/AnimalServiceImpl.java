package com.dh.animal.service.impl;

import com.dh.animal.dto.AnimalDTO;
import com.dh.animal.entity.Animal;
import com.dh.animal.repository.AnimalRepository;
import com.dh.animal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository repository;


    @Override
    public AnimalDTO salvar(AnimalDTO dto) {
        Animal entity = new Animal();
        entity.setNome(dto.getNome());
        entity.setIdEspecie(dto.getIdEspecie());
        return entityToDTO(repository.save(entity));
    }

    @Override
    public List<AnimalDTO> pesquisarPorIdEspecie(Long id) {
        return repository.findByIdEspecie(id)
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    private AnimalDTO entityToDTO(Animal animal) {
        return AnimalDTO.builder()
                .id(animal.getId())
                .nome(animal.getNome())
                .idEspecie(animal.getIdEspecie())
                .build();
    }

}
