package com.uc.secure_app.repository;

import com.uc.secure_app.entity.UserEntity;
import java.util.Optional;

public interface UserRepository {
    Optional<UserEntity> findByUsername(String username);
}
