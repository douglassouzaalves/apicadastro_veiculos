package br.com.cadastro.veiculos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class VeiculoRequest {

    private final UUID id;
    private final String nome;
    private final String marca;
    private final String modelo;
    private final LocalDate dataDeFabricacao;
    private final BigDecimal cidadeConsumo;
    private final BigDecimal estradaConsumo;

    public VeiculoRequest(UUID id, String nome, String marca, String modelo,
                          LocalDate dataDeFabricacao, BigDecimal cidadeConsumo, BigDecimal estradaConsumo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.dataDeFabricacao = dataDeFabricacao;
        this.cidadeConsumo = cidadeConsumo;
        this.estradaConsumo = estradaConsumo;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDate getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    public BigDecimal getCidadeConsumo() {
        return cidadeConsumo;
    }

    public BigDecimal getEstradaConsumo() {
        return estradaConsumo;
    }
}
