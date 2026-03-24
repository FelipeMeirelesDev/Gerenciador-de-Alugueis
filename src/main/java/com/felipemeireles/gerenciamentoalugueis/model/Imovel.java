package com.felipemeireles.gerenciamentoalugueis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Imovel {

    @Id
    private Long id;

    private String bairro;
    private String endereço;
    private String rua;
    private String numero;
    private Double valor_aluguel;
    private boolean disponibilidade;


    public Imovel(){

    }

    public Imovel(Long id, String bairro, String endereço, String rua, String numero,Double valor_aluguel, boolean disponibilidade) {
        this.id = id;
        this.bairro = bairro;
        this.endereço = endereço;
        this.rua = rua;
        this.numero = numero;
        this.valor_aluguel = valor_aluguel;
        this.disponibilidade = disponibilidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
