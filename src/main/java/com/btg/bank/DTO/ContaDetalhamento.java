package com.btg.bank.DTO;

import com.btg.bank.Entity.Conta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContaDetalhamento(Long id,Long numero, String cpf, String nome, String agencia, BigDecimal saldo, String tipoConta, LocalDate data, Boolean ativo) {
    public ContaDetalhamento(Conta contaEntity) {
        this(contaEntity.getId(),contaEntity.getNumero(),contaEntity.getCpf(),contaEntity.getNome(), contaEntity.getAgencia(),contaEntity.getSaldo(), contaEntity.getTipoConta(),contaEntity.getDtAbertura(), contaEntity.getAtivo());
    }
}
