package com.springboot.crud.sprinboot_app.repositories;

import com.springboot.crud.sprinboot_app.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsername(String s);

    Optional<User> findByUsername(String username);
}
