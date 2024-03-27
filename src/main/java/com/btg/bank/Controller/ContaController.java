package com.btg.bank.Controller;

import com.btg.bank.DTO.ContaDTO;
import com.btg.bank.DTO.ContaDetalhamento;
import com.btg.bank.Entity.Conta;
import com.btg.bank.Repository.ContaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/")
public class ContaController {
    @Autowired
    ContaRepository contaRepository;
    @GetMapping
    public String Dupla(){
        return """
                    {
                    "integrantes":[
                        { 
                            "nome": "julia nery"
                        },
                        {
                            "nome": "gustavo costa"
                        }
                    ]
                }
                """;
    }

    @PostMapping("cadastrar")
    public ResponseEntity cadastrar(@RequestBody @Valid Conta contaEntity, UriComponentsBuilder uriBuilder){

        contaRepository.save(contaEntity);
        var uri = uriBuilder.path("/conta/{id}").buildAndExpand(contaEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(new ContaDetalhamento(contaEntity));
    }

    @GetMapping("busca_id/{id}")
    public ResponseEntity buscarContaById(@PathVariable Long id){
        var conta = contaRepository.findById(id);
        return ResponseEntity.ok().body(conta);
    }
    @GetMapping("busca_cpf/{cpf}")
    public ResponseEntity buscarContaByCPF(@PathVariable String cpf){
        var conta = contaRepository.findByCpf(cpf);
        return ResponseEntity.ok().body(conta);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity desativarContas(@PathVariable Long id){
        Conta conta = contaRepository.findById(id).orElse(null);
        conta.setAtivo(false);
        contaRepository.save(conta);

        return ResponseEntity.noContent().build();
    }
//    @PutMapping
//    public ResponseEntity sacar(@PathVariable Long id, @RequestBody BigDecimal saque){
//        Conta conta = contaRepository.findById(id).orElse(null);
//        BigDecimal novoSaldo = conta.getSaldo() - saque;
//        conta.setSaldo(conta.getSaldo());
//        contaRepository.save(conta);
//        return ResponseEntity.ok().body(conta);
//    }
    @PutMapping("deposito/{id}")
    public ResponseEntity depositar(@PathVariable Long id, @RequestBody BigDecimal deposito){
        Conta conta = contaRepository.findById(id).orElse(null);
        if (conta == null) {
            return ResponseEntity.notFound().build();
        }
        BigDecimal novoSaldo = conta.getSaldo().add(deposito);
        conta.setSaldo(novoSaldo);
        contaRepository.save(conta);
        return ResponseEntity.ok().body(conta);
    }
}
