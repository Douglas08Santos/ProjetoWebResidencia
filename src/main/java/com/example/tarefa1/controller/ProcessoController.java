package com.example.tarefa1.controller;

import com.example.tarefa1.model.Processo;
import com.example.tarefa1.service.ProcessoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProcessoController {

    ProcessoService service;

    public ProcessoController(ProcessoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Processo> listAll(){
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<Processo> insert(@RequestBody Processo p){
        return ResponseEntity.status(
                201).body(service.insert(p));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Processo> update(@RequestBody Processo p,
                                          @PathVariable Long id){
        return service.findById(id).map(cliente -> {
            service.update(p);
            return ResponseEntity.ok().body(p);
        }).orElse(ResponseEntity.notFound().build());
    }
}
