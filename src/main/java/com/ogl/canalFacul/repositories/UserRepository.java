package com.ogl.canalFacul.repositories;

import com.ogl.canalFacul.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users, String> {
    public UserDetails findByEmail(String email);
}
