package com.uc.secure_app.repository;

import com.uc.secure_app.entity.UserEntity;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public class MockUserRepository {

    private final List<UserEntity> users = new ArrayList<>();

    public MockUserRepository() {
        // In-memory user setup (for demonstration purposes)
        users.add(new UserEntity(1L, "admin", "admin@example.com"));
        users.add(new UserEntity(2L, "user", "user@example.com"));
    }

    public Optional<UserEntity> findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }
}