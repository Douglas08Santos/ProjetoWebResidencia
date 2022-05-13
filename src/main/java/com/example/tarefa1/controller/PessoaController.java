package com.example.tarefa1.controller;

import com.example.tarefa1.model.Pessoa;
import com.example.tarefa1.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PessoaController {

    PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    /*
     * Retorna uma lista de todas as pessoas
     */
    @GetMapping
    public List<Pessoa> listAll(){
        return service.listAll();
    }

    /*
     * Adicionar uma nova pessoa
     */
    @PostMapping
    public ResponseEntity<Pessoa> insert(@RequestBody Pessoa p){
        return ResponseEntity.status(
                201).body(service.insert(p));
    }

    /*
     * Atualizar Pessoa pelo id
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa p,
                                          @PathVariable Long id){
        return service.findById(id).map(pessoa -> {
            service.update(p);
            return ResponseEntity.ok().body(p);
        }).orElse(ResponseEntity.notFound().build());
    }
}
