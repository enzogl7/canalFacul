package com.ogl.canalFacul.service;

import com.ogl.canalFacul.model.Curso;
import com.ogl.canalFacul.model.Users;

import java.util.List;

public interface CursoService {
    void saveCurso(Curso curso);
    List<Curso> findAllByUsuarioAdmin(Users user);
}
