package com.adriel.rural.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Funcionario {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
    private Instant dataDeNascimento;
    
    private String cargo;
    private Double salario;

    @ManyToOne @JoinColumn(name = "fazenda_id") @JsonIgnore
    private Fazenda fazenda;

    public Funcionario(){}

    public Funcionario(Long id, String nome, String sobrenome, Instant dataDeNascimento, String cargo, Double salario, 
            Fazenda fazenda) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataDeNascimento = dataDeNascimento;
        this.cargo = cargo;
        this.salario = salario;
        this.fazenda = fazenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Instant getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Instant dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
