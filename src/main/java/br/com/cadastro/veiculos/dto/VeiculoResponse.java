package br.com.cadastro.veiculos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class VeiculoResponse implements Comparable{

    private final UUID id;
    private final String nome;
    private final String marca;
    private final String modelo;
    private final LocalDate dataDeFabricacao;
    private final Float cidadeConsumo;
    private final Float estradaConsumo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal gasolinaConsumida;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal total;

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

    public BigDecimal getGasolinaConsumida() {
        return gasolinaConsumida;
    }

    public void setCombustivelConsumido(BigDecimal consumoGasolina) {
        this.gasolinaConsumida = consumoGasolina;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int compareTo(Object o) {
        VeiculoResponse other = (VeiculoResponse) o;
        if (other == null) return 0;
        if (this.getTotal().compareTo(other.getTotal()) > 1) {
            return 1;
        } else if (this.getTotal().compareTo(other.getTotal()) < -1) {
            return -1;
        }
        return 0;
    }

}
