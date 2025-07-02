package com.ogl.canalFacul.service.impl;

import com.ogl.canalFacul.controller.exception.RecursoNaoEncontradoException;
import com.ogl.canalFacul.model.Curso;
import com.ogl.canalFacul.model.Users;
import com.ogl.canalFacul.repositories.CursoRepository;
import com.ogl.canalFacul.service.CursoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {
    private final CursoRepository cursoRepository;
    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public void saveCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public List<Curso> findAllByUsuarioAdmin(Users user) {
        return cursoRepository.findAllByUsuarioAdmin(user);
    }

    @Override
    public Curso findById(String id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Curso não encontrado para esse ID."));
    }

    @Override
    public void deleteCurso(Curso curso) {
        cursoRepository.delete(curso);
    }

    @Override
    public Integer countTotalCursoByUsuario(Users user) {
        return cursoRepository.countAllByUsuarioAdmin(user);
    }

    @Override
    public Integer countCursosMesByUsuario(Users user) {
        return cursoRepository.countAllByUsuarioAdminAndCreatedAtBetween(user, LocalDate.now().withDayOfMonth(1).atStartOfDay(),  LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).atTime(23, 59, 59));
    }
}
