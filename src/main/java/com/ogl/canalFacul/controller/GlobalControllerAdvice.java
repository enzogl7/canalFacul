package com.ogl.canalFacul.controller;

import com.ogl.canalFacul.model.UserRole;
import com.ogl.canalFacul.model.Users;
import com.ogl.canalFacul.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public void addUsuarioToModel(Model model, HttpSession session) {
        Users usuario = userService.getUsuarioLogado();

        if (usuario == null) {
            usuario = new Users();
            usuario.setNome("--");
            usuario.setRole(UserRole.valueOf("USER"));
        }
        model.addAttribute("usuario", usuario);
    }
}