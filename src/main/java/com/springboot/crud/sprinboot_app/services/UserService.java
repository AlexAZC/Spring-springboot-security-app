package com.springboot.crud.sprinboot_app.services;

import com.springboot.crud.sprinboot_app.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String s);




}
