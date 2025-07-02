package com.ogl.canalFacul.repositories;

import com.ogl.canalFacul.model.Curso;
import com.ogl.canalFacul.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {
    List<Curso> findAllByUsuarioAdmin(Users usuarioAdmin);

    Integer countAllByUsuarioAdmin(Users usuarioAdmin);

    Integer countAllByUsuarioAdminAndCreatedAtBetween(Users usuarioAdmin, LocalDateTime createdAtAfter, LocalDateTime createdAtBefore);
}
