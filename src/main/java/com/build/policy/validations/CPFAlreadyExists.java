package com.build.policy.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CPFAlreadyExistsValidator.class)
public @interface CPFAlreadyExists {

    String message() default "CPF already exists in the database";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
