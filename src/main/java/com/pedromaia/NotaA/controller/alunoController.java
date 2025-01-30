package com.pedromaia.NotaA.controller;

import com.pedromaia.NotaA.model.Aluno;
import com.pedromaia.NotaA.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/aluno")
@Validated
public class alunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable int id) {
        Aluno obj = this.alunoService.findbyId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Validated(Aluno.CreateAluno.class)
    public ResponseEntity<Aluno> save(@RequestBody @Valid Aluno obj) {
        this.alunoService.create(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping("/{id}")
    @Validated(Aluno.UpdateAluno.class)
    public ResponseEntity<Aluno> update(@PathVariable int id, @RequestBody @Valid Aluno obj) {
       obj.setId(id);
       this.alunoService.update(obj);
       return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
