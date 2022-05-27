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
public class Acompanhamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT")
    private Instant dataRealizado;

    private Double altura;
    private Double peso;
    private boolean vermifugado;

    @ManyToOne @JoinColumn(name = "animal_id") @JsonIgnore
    private Animal animal;

    public Acompanhamento(){}

    public Acompanhamento(Long id, Instant dataRealizado, Double altura, Double peso, boolean vermifugado,
            Animal animal) {
        this.id = id;
        this.dataRealizado = dataRealizado;
        this.altura = altura;
        this.peso = peso;
        this.vermifugado = vermifugado;
        this.animal = animal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataRealizado() {
        return dataRealizado;
    }

    public void setDataRealizado(Instant dataRealizado) {
        this.dataRealizado = dataRealizado;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public boolean isVermifugado() {
        return vermifugado;
    }

    public void setVermifugado(boolean vermifugado) {
        this.vermifugado = vermifugado;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
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
        Acompanhamento other = (Acompanhamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
