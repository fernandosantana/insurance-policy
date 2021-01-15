package com.build.policy.validations;

import com.build.policy.model.Customer;
import com.build.policy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class CPFAlreadyExistsValidator implements ConstraintValidator<CPFAlreadyExists, String> {

    @Autowired
    private CustomerRepository repository;

    @Override
    public void initialize(CPFAlreadyExists constraintAnnotation) {}

    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        Optional<Customer> opCustomer = this.repository.findByCpf(cpf);
        return !opCustomer.isPresent();
    }
}
