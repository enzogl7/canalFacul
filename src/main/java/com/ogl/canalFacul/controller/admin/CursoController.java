package com.ogl.canalFacul.controller.admin;

import com.ogl.canalFacul.model.Curso;
import com.ogl.canalFacul.model.dto.CursoDTO;
import com.ogl.canalFacul.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    private String gerarCodigoCurso() {
        return UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

    @GetMapping("/novocurso")
    public String novocurso() {
        return "admin/novocurso";
    }

    @GetMapping("/cursos")
    public String meuscursos() {
        return "admin/cursos";
    }

    @PostMapping("/criarcurso")
    public ResponseEntity<?> criarCurso(@Valid @RequestBody CursoDTO cursoDTO) {
        Curso novoCurso = new Curso();
        novoCurso.setNome(cursoDTO.nome());
        novoCurso.setDescricao(cursoDTO.descricao());
        novoCurso.setModalidade(cursoDTO.modalidade());
        novoCurso.setTurma(cursoDTO.turma());
        novoCurso.setCodigoCadastro(gerarCodigoCurso());

        cursoService.saveCurso(novoCurso);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoCurso);
    }

}
