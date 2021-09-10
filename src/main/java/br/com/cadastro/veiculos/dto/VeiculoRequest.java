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

    public VeiculoRequest(UUID id, String name, String make, String model,
                          LocalDate manufactureDate, BigDecimal cityConsumption, BigDecimal highwayConsumption) {
        this.id = id;
        this.nome = name;
        this.marca = make;
        this.modelo = model;
        this.dataDeFabricacao = manufactureDate;
        this.cidadeConsumo = cityConsumption;
        this.estradaConsumo = highwayConsumption;
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
