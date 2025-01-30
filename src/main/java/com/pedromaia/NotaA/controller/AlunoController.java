package com.pedromaia.NotaA.controller;

import com.pedromaia.NotaA.DTO.AlunoDTO;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sala")
@Validated
public class AlunoController {

    @Autowired
    private AlunoService alunoService;


    @GetMapping
    public List<AlunoDTO> findAllAlunos() {
        return this.alunoService.findAll()
                .stream()
                .map(aluno -> new AlunoDTO(
                        aluno.getNome(),
                        (aluno.getNotaMatematica() + aluno.getNotaPortugues() +
                                aluno.getNotaCiencia() + aluno.getNotaGeografia() +
                                aluno.getNotaLiteratura()) / 5,
                        aluno.getFrequencia()
                ))
                .collect(Collectors.toList());
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
    public ResponseEntity<Float> classAvarege() {
        float media = this.alunoService.calculateClassAverageGrade();
        return ResponseEntity.ok().body(media);
    }

    @GetMapping("/media-matematica")
    public ResponseEntity<Float> classAvaregeInMatematica() {
        float media = this.alunoService.calculateClassAverageGradeInMatematica();
        return ResponseEntity.ok().body(media);
    }

    @GetMapping("/media-portugues")
    public ResponseEntity<Float> classAvaregeInPortugues() {
        float media = this.alunoService.calculateClassAverageGradeInPortugues();
        return ResponseEntity.ok().body(media);
    }

    @GetMapping("/media-ciencia")
    public ResponseEntity<Float> classAvaregeInCiencia() {
        float media = this.alunoService.calculateClassAverageGradeInCiencia();
        return ResponseEntity.ok().body(media);
    }

    @GetMapping("/media-geografia")
    public ResponseEntity<Float> classAvaregeInGeografia() {
        float media = this.alunoService.calculateClassAverageGradeInGeografia();
        return ResponseEntity.ok().body(media);
    }

    @GetMapping("/media-literatura")
    public ResponseEntity<Float> classAvaregeInLiteratura() {
        float media = this.alunoService.calculateClassAverageGradeInLiteratura();
        return ResponseEntity.ok().body(media);
    }

    @PostMapping
    @Validated(Aluno.CreateAluno.class)
    public ResponseEntity<Aluno> save(@RequestBody @Valid Aluno obj) {
        this.alunoService.create(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
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
