package com.springboot.crud.sprinboot_app.controllers;


import com.springboot.crud.sprinboot_app.entities.User;
import com.springboot.crud.sprinboot_app.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://holamundo.com",originPatterns = "*") // Sirve para la conexion entre los servidores Frontend con el Backend
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;


    //VALIDATION-PERSONALITATION
    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }


    @GetMapping
    public List<User> list() {
        return service.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {

        if (result.hasFieldErrors()) {
            return validation(result);
        }

        User userDb = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDb);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result) {
        user.setAdmin(false);

        return create(user, result);
    }















}
