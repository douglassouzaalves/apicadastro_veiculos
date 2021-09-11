package br.com.cadastro.veiculos.dto;


import java.time.LocalDate;
import java.util.UUID;

public class VeiculoResponse {

    private final UUID id;
    private final String nome;
    private final String marca;
    private final String modelo;
    private final LocalDate dataDeFabricacao;
    private final Float cidadeConsumo;
    private final Float estradaConsumo;


    public VeiculoResponse(UUID id, String nome, String marca, String modelo, LocalDate dataDeFabricacao,
                           Float cidadeConsumo, Float estradaConsumo) {
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

    public Float getCidadeConsumo() {
        return cidadeConsumo;
    }

    public Float getEstradaConsumo() {
        return estradaConsumo;
    }

}
