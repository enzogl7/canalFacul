package com.ogl.canalFacul.service;

import com.ogl.canalFacul.model.Users;
import com.ogl.canalFacul.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Users getUsuarioLogado() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return (Users) userRepository.findByEmail(username);
    }
}
