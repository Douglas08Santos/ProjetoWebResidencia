package com.example.tarefa1.service;

import com.example.tarefa1.model.Processo;
import com.example.tarefa1.repository.ProcessoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoService {

    ProcessoRepository repository;

    public ProcessoService(ProcessoRepository repository){
        this.repository = repository;
    }

    public Processo insert(Processo p){
        return repository.save(p);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Processo> listAll(){
        return repository.findAll();
    }

    public Optional<Processo> findById(Long id){
        return repository.findById(id);
    }

    public Processo update(Processo p){
        return repository.saveAndFlush(p);
    }
}
