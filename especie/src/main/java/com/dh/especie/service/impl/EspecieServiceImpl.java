package com.dh.especie.service.impl;

import com.dh.especie.dto.AnimalDTO;
import com.dh.especie.dto.EspecieDTO;
import com.dh.especie.entity.Especie;
import com.dh.especie.repository.EspecieRepository;
import com.dh.especie.service.AnimalFeign;
import com.dh.especie.service.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EspecieServiceImpl implements EspecieService {

    @Autowired
    private EspecieRepository repository;

    @Autowired
    private AnimalFeign animalFeign;

    @Override
    public EspecieDTO salvar(EspecieDTO dto) {
        Especie entity = new Especie();
        entity.setNomeEspecie(dto.getNomeEspecie());
        return entityToDTO(repository.save(entity));
    }

    @Override
    public EspecieDTO pesquisarPorId(Long id) {
        Especie especie = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return entityToDTO(especie);
    }

    @Override
    public EspecieDTO pesquisarPorNome(String nome) {
        Especie especie = repository.findByNomeEspecie(nome).orElseThrow(EntityNotFoundException::new);
        return entityToDTO(especie);
    }

    @Override
    public List<AnimalDTO> pesquisarAnimais(String nomeEspecie) {
        EspecieDTO especieDTO = pesquisarPorNome(nomeEspecie);
        return animalFeign.pesquisarPorIdEspecie(especieDTO.getId()).getBody();
    }

    private EspecieDTO entityToDTO(Especie especie) {
        return EspecieDTO.builder()
                .id(especie.getId())
                .nomeEspecie(especie.getNomeEspecie())
                .build();
    }

}
