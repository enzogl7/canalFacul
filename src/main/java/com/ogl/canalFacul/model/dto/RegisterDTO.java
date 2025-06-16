package com.ogl.canalFacul.model.dto;

import com.ogl.canalFacul.model.UserRole;

public record RegisterDTO(String nome, String matricula, String celular, String email, String password, UserRole role) {
}
