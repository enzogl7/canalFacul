package com.ogl.canalFacul.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class EstudantesController {
    @GetMapping("/estudantes")
    public String estudantes() {
        return "admin/estudantes";
    }
}
