package com.springboot.crud.sprinboot_app.validation;

import com.springboot.crud.sprinboot_app.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsByUsernameValidation implements ConstraintValidator<ExistsByUsername, String> {

    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(service == null){
            return true;
        }

        return !service.existsByUsername(s);
    }
}
