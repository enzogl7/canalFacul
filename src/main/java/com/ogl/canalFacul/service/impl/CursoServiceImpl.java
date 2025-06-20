package com.ogl.canalFacul.service.impl;

import com.ogl.canalFacul.model.Curso;
import com.ogl.canalFacul.repositories.CursoRepository;
import com.ogl.canalFacul.service.CursoService;
import org.springframework.stereotype.Service;

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

}
