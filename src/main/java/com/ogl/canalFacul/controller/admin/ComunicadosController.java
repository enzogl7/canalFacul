package com.ogl.canalFacul.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class ComunicadosController {
    @GetMapping("/comunicados")
    public String comunicados() {
        return "admin/comunicados";
    }

    @GetMapping("/novocomunicado")
    public String novocomunicado() {
        return "admin/novocomunicado";
    }
}
