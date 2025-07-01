package com.ogl.canalFacul.controller.admin;

import com.ogl.canalFacul.model.Curso;
import com.ogl.canalFacul.model.dto.CursoDTO;
import com.ogl.canalFacul.service.CursoService;
import com.ogl.canalFacul.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @Autowired
    private UserService userService;

    private String gerarCodigoCurso() {
        return UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

    @GetMapping("/novocurso")
    public String novocurso() {
        return "admin/novocurso";
    }

    @GetMapping("/cursos")
    public String meuscursos(Model model) {
        model.addAttribute("cursos", cursoService.findAllByUsuarioAdmin(userService.getUsuarioLogado()));
        return "admin/cursos";
    }

    @PostMapping("/novocurso")
    public ResponseEntity<?> criarCurso(@Valid @RequestBody CursoDTO cursoDTO) {
        Curso novoCurso = new Curso();
        novoCurso.setNome(cursoDTO.nome());
        novoCurso.setDescricao(cursoDTO.descricao());
        novoCurso.setModalidade(cursoDTO.modalidade());
        novoCurso.setTurma(cursoDTO.turma());
        novoCurso.setCodigoCadastro(gerarCodigoCurso());
        novoCurso.setUsuarioAdmin(userService.getUsuarioLogado());

        cursoService.saveCurso(novoCurso);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoCurso);
    }

    @DeleteMapping("/excluircurso")
    public ResponseEntity<?> excluirCurso(@RequestParam String id) {
        Curso curso = cursoService.findById(id);
        cursoService.deleteCurso(curso);
        return ResponseEntity.ok().build();
    }

}
