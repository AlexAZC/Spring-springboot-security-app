package com.springboot.crud.sprinboot_app.validation;

import com.springboot.crud.sprinboot_app.services.ProductService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IsExistsDbValidation implements ConstraintValidator<IsExistsDb, String > {

    @Autowired
    private ProductService productService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(productService == null){
            return true;
        }
        return !productService.existsBySku(s);
    }

}
