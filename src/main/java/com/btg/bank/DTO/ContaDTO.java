package com.btg.bank.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContaDTO(Long numero, String cpf, String nome, String agencia, BigDecimal saldo, String tipoConta) {
}
