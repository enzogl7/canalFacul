package com.ogl.canalFacul.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class ConfiguracoesController {
    @GetMapping("/configuracoes")
    public String configuracoes() {
        return "admin/configuracoes";
    }
}
