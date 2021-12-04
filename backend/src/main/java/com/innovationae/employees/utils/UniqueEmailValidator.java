package com.innovationae.employees.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.innovationae.employees.repository.EmployeeRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return employeeRepository.findByEmailId(email)==null;
    }
}
