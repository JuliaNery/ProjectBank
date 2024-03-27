package com.btg.bank.Entity;

import com.btg.bank.validation.TipoConta;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @NotBlank(message = "{conta.nome.notblank}")
    public String nome;
    @CPF(message = "{conta.cpf.cpf}")
    public  String cpf;
    public Long numero;
    public String agencia;
    @PastOrPresent
    public LocalDate dtAbertura;
    @Positive(message = "{conta.saldo.positive}")
    public BigDecimal saldo;
    public Boolean ativo;
    @TipoConta
    public String tipoConta;
}
