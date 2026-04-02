package com.felipemeireles.gerenciamentoalugueis.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_imovel")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bairro;
    private String rua;
    private String numero;
    private Double valor_aluguel;
    private Boolean disponibilidade;

    // @OneToMany(mappedBy = "imovel")
    // private List<Contrato> contratos;


    public Imovel(){

    }

    public Imovel(Long id, String bairro, String rua, String numero,Double valor_aluguel, boolean disponibilidade /*List<Contrato> contratos*/) {
        this.id = id;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.valor_aluguel = valor_aluguel;
        this.disponibilidade = disponibilidade;
        //this.contratos = contratos;
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

    public Double getValor_aluguel() {
        return valor_aluguel;
    }

    public void setValor_aluguel(Double valor_aluguel) {
        this.valor_aluguel = valor_aluguel;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    /*public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }*/
}
