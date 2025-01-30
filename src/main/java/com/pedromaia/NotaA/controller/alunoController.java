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
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/sala")
@Validated
public class alunoController {

    @Autowired
    private AlunoService alunoService;


    @GetMapping
    public ResponseEntity<List<Aluno>> findAllAlunos() {
        List<Aluno> objs = this.alunoService.findAll();
        return ResponseEntity.ok().body(objs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable int id) {
        Aluno obj = this.alunoService.findbyId(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/alunos-frequencia-baixa")
    public ResponseEntity<LinkedList<String>> findAlunosFrequenciaBaixa() {
        LinkedList<String> objs = this.alunoService.findAlunosByLowFrenquecia();
        return ResponseEntity.ok().body(objs);
    }

    @GetMapping("/media")
    public ResponseEntity<Double> classAvarege() {
        Double media = this.alunoService.calculateClassAverageGrade();
        return ResponseEntity.ok().body(media);
    }

    @GetMapping("/media-matematica")
    public ResponseEntity<Double> classAvaregeInMatematica() {
        Double media = this.alunoService.calculateClassAverageGradeInMatematica();
        return ResponseEntity.ok().body(media);
    }

    @GetMapping("/media-portugues")
    public ResponseEntity<Double> classAvaregeInPortugues() {
        Double media = this.alunoService.calculateClassAverageGradeInPortugues();
        return ResponseEntity.ok().body(media);
    }

    @GetMapping("/media-ciencia")
    public ResponseEntity<Double> classAvaregeInCiencia() {
        Double media = this.alunoService.calculateClassAverageGradeInCiencia();
        return ResponseEntity.ok().body(media);
    }

    @GetMapping("/media-geografia")
    public ResponseEntity<Double> classAvaregeInGeografia() {
        Double media = this.alunoService.calculateClassAverageGradeInGeografia();
        return ResponseEntity.ok().body(media);
    }

    @GetMapping("/media-literatura")
    public ResponseEntity<Double> classAvaregeInLiteratura() {
        Double media = this.alunoService.calculateClassAverageGradeInLiteratura();
        return ResponseEntity.ok().body(media);
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
