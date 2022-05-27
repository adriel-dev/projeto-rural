package com.adriel.rural.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Animal {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sexo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
    private Instant dataAquisicao;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
    private Instant dataVenda;

    private Double valorAquisicao;
    private Double valorVenda;
    private String imgAnimalUrl;

    @ManyToOne @JoinColumn(name = "raca_id")
    private Raca raca;

    @OneToMany(mappedBy = "animal")
    private List<Acompanhamento> acompanhamentos = new ArrayList<>();
    
    @ManyToOne @JoinColumn(name = "fazenda_id")
    private Fazenda fazenda;

    public Animal(){}

    public Animal(Long id, String nome, String sexo, Instant dataAquisicao, Instant dataVenda, Double valorAquisicao,
            Double valorVenda, String imgAnimalUrl, Raca raca, Fazenda fazenda) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dataAquisicao = dataAquisicao;
        this.dataVenda = dataVenda;
        this.valorAquisicao = valorAquisicao;
        this.valorVenda = valorVenda;
        this.imgAnimalUrl = imgAnimalUrl;
        this.raca = raca;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Instant getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Instant dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Instant getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Instant dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(Double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getImgAnimalUrl() {
        return imgAnimalUrl;
    }
    
    public void setImgAnimalUrl(String imgAnimalUrl) {
        this.imgAnimalUrl = imgAnimalUrl;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public List<Acompanhamento> getAcompanhamentos() {
        return acompanhamentos;
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
        Animal other = (Animal) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}