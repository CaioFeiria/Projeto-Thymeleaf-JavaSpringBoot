package com.example.Thymeleaf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FuncionarioModel {

    @Id
    private String cpf;
    private String nome;
    private Double salario;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
