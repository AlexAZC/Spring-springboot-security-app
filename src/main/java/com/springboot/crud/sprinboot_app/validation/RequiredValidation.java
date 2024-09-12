package com.springboot.crud.sprinboot_app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;


public class RequiredValidation implements ConstraintValidator<IsRequired, String> {


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //Otra manera
        //return StringUtils.hasText(s);

        if(s != null && !s.isEmpty() && !s.isBlank()){
            return true;
        }
        return false;
    }
}
