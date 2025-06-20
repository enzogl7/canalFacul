package com.ogl.canalFacul.service.impl;

import com.ogl.canalFacul.model.Curso;
import com.ogl.canalFacul.model.Users;
import com.ogl.canalFacul.repositories.CursoRepository;
import com.ogl.canalFacul.service.CursoService;
import org.springframework.stereotype.Service;

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

}
