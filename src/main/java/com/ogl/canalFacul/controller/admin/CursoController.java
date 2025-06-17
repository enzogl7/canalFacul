package com.ogl.canalFacul.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CursoController {
    @GetMapping("/novocurso")
    public String novocurso() {
        return "admin/novocurso";
    }

    @GetMapping("/cursos")
    public String meuscursos() {
        return "admin/cursos";
    }
}
