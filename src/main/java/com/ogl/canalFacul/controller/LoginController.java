package com.ogl.canalFacul.controller;

import com.ogl.canalFacul.infra.security.TokenService;
import com.ogl.canalFacul.model.Users;
import com.ogl.canalFacul.model.dto.AuthenticationDTO;
import com.ogl.canalFacul.model.dto.LoginResponseDTO;
import com.ogl.canalFacul.model.dto.RegisterDTO;
import com.ogl.canalFacul.repositories.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @PostMapping("/logar")
    public ResponseEntity logar(@RequestBody AuthenticationDTO data, HttpServletResponse response) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var authentication = authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((Users) authentication.getPrincipal());

            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            cookie.setMaxAge(3600);
            response.addCookie(cookie);

             Users user = (Users) userRepository.findByEmail(data.email());
            Map<String, Object> body = new HashMap<>();
            body.put("token", token);
            body.put("role", user.getRole());
            return ResponseEntity.ok(body);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody RegisterDTO data) {
        if (userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users newUser = new Users(data.nome(), data.matricula(), data.celular(), data.email(), encryptedPassword, data.role());

        userRepository.save(newUser);
        return ResponseEntity.ok().build();

    }
}
