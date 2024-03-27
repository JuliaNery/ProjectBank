package com.btg.bank.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Constraint(validatedBy = TipoContaValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoConta {
    String message() default "Tipo de Conta Invalida";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
