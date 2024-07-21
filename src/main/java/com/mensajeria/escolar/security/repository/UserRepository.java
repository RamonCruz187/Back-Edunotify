package com.mensajeria.escolar.security.repository;

import com.mensajeria.escolar.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    User getUserById(Long id);
}
