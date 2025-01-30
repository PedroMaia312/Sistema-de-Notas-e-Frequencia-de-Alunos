package com.pedromaia.NotaA.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "aluno")
public class Aluno {

    public interface CreateAluno {
    }
    public interface UpdateAluno {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotNull(groups = {CreateAluno.class, UpdateAluno.class})
    @NotEmpty(groups = {CreateAluno.class, UpdateAluno.class})
    private String nome;

    @Column(name = "nota_matematica", length = 100, nullable = false)
    @NotNull(groups = {CreateAluno.class, UpdateAluno.class})
    @NotEmpty(groups = {CreateAluno.class, UpdateAluno.class})
    private float notaMatematica;

    @Column(name = "nota_portuguese", length = 100, nullable = false)
    @NotNull(groups = {CreateAluno.class, UpdateAluno.class})
    @NotEmpty(groups = {CreateAluno.class, UpdateAluno.class})
    private float notaPortugues;

    @Column(name = "nota_ciencia", length = 100, nullable = false)
    @NotNull(groups = {CreateAluno.class, UpdateAluno.class})
    @NotEmpty(groups = {CreateAluno.class, UpdateAluno.class})
    private float notaCiencia;

    @Column(name = "nota_geografia", length = 100, nullable = false)
    @NotNull(groups = {CreateAluno.class, UpdateAluno.class})
    @NotEmpty(groups = {CreateAluno.class, UpdateAluno.class})
    private float notaGeografia;

    @Column(name = "nota_literatura", length = 100, nullable = false)
    @NotNull(groups = {CreateAluno.class, UpdateAluno.class})
    @NotEmpty(groups = {CreateAluno.class, UpdateAluno.class})
    private float notaLiteratura;

    @Column(name = "frequencia", length = 100, nullable = false)
    @NotNull(groups = {CreateAluno.class, UpdateAluno.class})
    @NotEmpty(groups = {CreateAluno.class, UpdateAluno.class})
    private Double frequencia;

    public Aluno() {
    }

    public Aluno(Integer id, String nome, float notaMatematica, float notaPortugues, float notaCiencia, float notaGeografia, float notaLiteratura, Double frequencia) {
        this.id = id;
        this.nome = nome;
        this.notaMatematica = notaMatematica;
        this.notaPortugues = notaPortugues;
        this.notaCiencia = notaCiencia;
        this.notaGeografia = notaGeografia;
        this.notaLiteratura = notaLiteratura;
        this.frequencia = frequencia;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(float notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    public float getNotaPortugues() {
        return notaPortugues;
    }

    public void setNotaPortugues(float notaPortugues) {
        this.notaPortugues = notaPortugues;
    }

    public float getNotaCiencia() {
        return notaCiencia;
    }

    public void setNotaCiencia(float notaCiencia) {
        this.notaCiencia = notaCiencia;
    }

    public float getNotaGeografia() {
        return notaGeografia;
    }

    public void setNotaGeografia(float notaGeografia) {
        this.notaGeografia = notaGeografia;
    }

    public float getNotaLiteratura() {
        return notaLiteratura;
    }

    public void setNotaLiteratura(float notaLiteratura) {
        this.notaLiteratura = notaLiteratura;
    }

    public Double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Double frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Aluno))
            return false;

        Aluno other = (Aluno) obj;
        if (this.id == null)
            if (other.id != null)
                return false;
            else if (!this.id.equals(other.id))
                return false;

        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.nome, other.nome) &&
                Objects.equals(this.notaMatematica, other.notaMatematica) &&
                Objects.equals(this.notaPortugues, other.notaPortugues) &&
                Objects.equals(this.notaCiencia, other.notaCiencia) &&
                Objects.equals(this.notaGeografia, other.notaGeografia) &&
                Objects.equals(this.notaLiteratura, other.notaLiteratura) &&
                Objects.equals(this.frequencia, other.frequencia);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (this.id == null ? 0 : this.id.hashCode());
        return result;
    }
}
