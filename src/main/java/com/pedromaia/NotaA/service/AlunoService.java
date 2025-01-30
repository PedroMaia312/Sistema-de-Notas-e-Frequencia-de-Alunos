package com.pedromaia.NotaA.service;

import com.pedromaia.NotaA.model.Aluno;
import com.pedromaia.NotaA.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno findbyId(Integer id) {
        Optional<Aluno> aluno = this.alunoRepository.findById(id);
        return aluno.orElseThrow(() ->new RuntimeException(
                "Aluno não encontrada! id:" + id + ", Tipo: " + Aluno.class.getName()));
    }

    public List<Aluno> findAll() {
        return this.alunoRepository.findAll();
    }

    @Transactional
    public Aluno create(Aluno obj) {
        obj.setId(null);
        obj = this.alunoRepository.save(obj);
        return obj;
    }

    @Transactional
    public Aluno update(Aluno obj) {
        Aluno newobj = this.findbyId(obj.getId());
        newobj.setFrequencia(obj.getFrequencia());
        return this.alunoRepository.save(newobj);
    }

    public void delete(Integer id) {
        Aluno aluno = this.findbyId(id);
        try{
            this.alunoRepository.delete(aluno);
        } catch (Exception e){
            throw new RuntimeException("Erro ao excluir aluno");
        }
    }

    public LinkedList<String> findAlunosByLowFrenquecia() {
        LinkedList<String> alunosComBaixaFrequencia = this.alunoRepository.findAlunosWithLowestFrequencia();
        return alunosComBaixaFrequencia;
    }

    public double calculateClassAverageGrade() {
        Object[] notas = this.alunoRepository.findClassAverage();
        double averageGrade = (Double) notas[0];
        averageGrade *= (Integer) notas[1];
        return averageGrade;
    }

    public double calculateClassAverageGradeInMatematica() {
        Object[] notas = this.alunoRepository.findClassAverageInMatematica();
        double averageGrade = (Double) notas[0];
        averageGrade *= (Integer) notas[1];
        return averageGrade;
    }

    public double calculateClassAverageGradeInPortugues() {
        Object[] notas = this.alunoRepository.findClassAverageInPortugues();
        double averageGrade = (Double) notas[0];
        averageGrade *= (Integer) notas[1];
        return averageGrade;
    }

    public double calculateClassAverageGradeInCiencia() {
        Object[] notas = this.alunoRepository.findClassAverageInCiencia();
        double averageGrade = (Double) notas[0];
        averageGrade *= (Integer) notas[1];
        return averageGrade;
    }

    public double calculateClassAverageGradeInGeografia() {
        Object[] notas = this.alunoRepository.findClassAverageInGeografia();
        double averageGrade = (Double) notas[0];
        averageGrade *= (Integer) notas[1];
        return averageGrade;
    }

    public double calculateClassAverageGradeInLiteratura() {
        Object[] notas = this.alunoRepository.findClassAverageInLiteratura();
        double averageGrade = (Double) notas[0];
        averageGrade *= (Integer) notas[1];
        return averageGrade;
    }
}
