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

    public Object[] findAlunosByLowFrenquecia() {
        Object[] alunosComBaixaFrequencia = this.alunoRepository.findAlunosWithLowestFrequencia();
        return alunosComBaixaFrequencia;
    }

    public Float calculateClassAverageGrade() {
        return this.alunoRepository.findClassAverage();
    }

    public Float calculateClassAverageGradeInMatematica() {
        return this.alunoRepository.findClassAverageInMatematica();
    }

    public Float calculateClassAverageGradeInPortugues() {
        return this.alunoRepository.findClassAverageInPortugues();

    }

    public Float calculateClassAverageGradeInCiencia() {
        return this.alunoRepository.findClassAverageInCiencia();
    }

    public Float calculateClassAverageGradeInGeografia() {
        return this.alunoRepository.findClassAverageInGeografia();
    }

    public Float calculateClassAverageGradeInLiteratura() {
        return this.alunoRepository.findClassAverageInLiteratura();

    }
}
