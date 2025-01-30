package com.pedromaia.NotaA.repository;

import com.pedromaia.NotaA.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.LinkedList;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {



    @Query("SELECT a.nome FROM Aluno a WHERE a.frequencia < 75 ORDER BY a.nome")
    LinkedList<String> findAlunosWithLowestFrequencia();

    @Query("SELECT SUM(a.notaMatematica), COUNT(a) FROM Aluno a")
    Object[] findClassAverageInMatematica();

    @Query("SELECT SUM(a.notaPortugues), COUNT(a) FROM Aluno a")
    Object[] findClassAverageInPortugues();

    @Query("SELECT SUM(a.notaCiencia), COUNT(a) FROM Aluno a")
    Object[] findClassAverageInCiencia();

    @Query("SELECT SUM(a.notaGeografia), COUNT(a) FROM Aluno a")
    Object[] findClassAverageInGeografia();

    @Query("SELECT SUM(a.notaLiteratura), COUNT(a) FROM Aluno a")
    Object[] findClassAverageInLiteratura();

    @Query("SELECT SUM(a.notaMatematica + a.notaPortugues + a.notaCiencia + a.notaGeografia + a.notaLiteratura), COUNT(a) FROM Aluno a")
    Object[] findClassAverage();
}
