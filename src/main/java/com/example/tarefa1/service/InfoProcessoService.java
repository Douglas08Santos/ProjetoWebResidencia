package com.example.tarefa1.service;

import com.example.tarefa1.model.InfoProcesso;
import com.example.tarefa1.repository.InfoProcessoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoProcessoService {

    InfoProcessoRepository repository;

    public InfoProcessoService(InfoProcessoRepository repository) {
        this.repository = repository;
    }
    public InfoProcesso insert(InfoProcesso info){
        return repository.save(info);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
    public List<InfoProcesso> listAll(){
        return repository.findAll();
    }

    public Optional<InfoProcesso> findById(Long id){
        return repository.findById(id);
    }

    public InfoProcesso update(InfoProcesso info){
        return repository.saveAndFlush(info);
    }
}
