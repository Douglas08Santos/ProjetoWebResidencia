package com.example.tarefa1.controller;

import com.example.tarefa1.model.InfoProcesso;
import com.example.tarefa1.model.Pessoa;
import com.example.tarefa1.service.InfoProcessoService;
import com.example.tarefa1.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class InfoProcessoController {
    InfoProcessoService service;

    public InfoProcessoController(InfoProcessoService service) {
        this.service = service;
    }

    /*
     * Retorna uma lista de todas as informações sobre os processos
     */
    @GetMapping
    public List<InfoProcesso> listAll(){
        return service.listAll();
    }

    /*
     * Adicionar novas informações sobre o Processo
     */
    @PostMapping
    public ResponseEntity<InfoProcesso> insert(@RequestBody InfoProcesso info){
        return ResponseEntity.status(
                201).body(service.insert(info));
    }

    /*
     * Atualizar informações do Processo pelo id
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<InfoProcesso> update(@RequestBody InfoProcesso info,
                                         @PathVariable Long id){
        return service.findById(id).map(infoProcesso -> {
            service.update(info);
            return ResponseEntity.ok().body(info);
        }).orElse(ResponseEntity.notFound().build());
    }
}
