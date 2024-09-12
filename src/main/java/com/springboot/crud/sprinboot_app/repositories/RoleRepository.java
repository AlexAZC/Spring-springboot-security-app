package com.springboot.crud.sprinboot_app.repositories;

import com.springboot.crud.sprinboot_app.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);



}
