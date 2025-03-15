package com.uc.secure_app.controller;

import com.uc.secure_app.entity.UserEntity;
import com.uc.secure_app.repository.MockUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final MockUserRepository userRepository;

    @Autowired
    public UserController(MockUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserEntity> getUser(@PathVariable String username) {
        return userRepository.findByUsername(username)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}