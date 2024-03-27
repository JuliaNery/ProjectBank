package com.btg.bank.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoContaValidator implements ConstraintValidator<TipoConta, String> {
    @Override
    public boolean isValid(String tipoConta, ConstraintValidatorContext constraintValidatorContext) {
        return tipoConta.equals("CORRENTE") || tipoConta.equals("POUPANÇA")|| tipoConta.equals("SALÁRIO");
    }
}
