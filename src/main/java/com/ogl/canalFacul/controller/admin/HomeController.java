package com.ogl.canalFacul.controller.admin;

import com.ogl.canalFacul.service.CursoService;
import com.ogl.canalFacul.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class HomeController {
    private final CursoService cursoService;
    private final UserService userService;

    public HomeController(CursoService cursoService, UserService userService) {
        this.cursoService = cursoService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("totalCursos", cursoService.countTotalCursoByUsuario(userService.getUsuarioLogado()));
        model.addAttribute("totalMes", cursoService.countCursosMesByUsuario(userService.getUsuarioLogado()));
        return "/admin/home";
    }

}
