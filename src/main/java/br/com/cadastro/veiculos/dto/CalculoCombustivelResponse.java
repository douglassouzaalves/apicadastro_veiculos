package br.com.cadastro.veiculos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CalculoCombustivelResponse implements Comparable {

    private String nome;
    private String marca;
    private String modelo;
    private LocalDate dataDeFabricacao;
    private BigDecimal quantidadeCombustivelGasto;
    private BigDecimal valorTotalGastoCombustivel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    public void setDataDeFabricacao(LocalDate dataDeFabricacao) {
        this.dataDeFabricacao = dataDeFabricacao;
    }

    public BigDecimal getQuantidadeCombustivelGasto() {
        return quantidadeCombustivelGasto;
    }

    public void setQuantidadeCombustivelGasto(BigDecimal quantidadeCombustivelGasto) {
        this.quantidadeCombustivelGasto = quantidadeCombustivelGasto;
    }

    public BigDecimal getValorTotalGastoCombustivel() {
        return valorTotalGastoCombustivel;
    }

    public void setValorTotalGastoCombustivel(BigDecimal valorTotalGastoCombustivel) {
        this.valorTotalGastoCombustivel = valorTotalGastoCombustivel;
    }

    @Override
    public int compareTo(Object o) {
        CalculoCombustivelResponse other = (CalculoCombustivelResponse) o;
        if (other == null) return 0;
        if (this.getValorTotalGastoCombustivel().compareTo(other.getValorTotalGastoCombustivel()) > 1) {
            return 1;
        } else if (this.getValorTotalGastoCombustivel().compareTo(other.getValorTotalGastoCombustivel()) < -1) {
            return -1;
        }
        return 0;
    }
}
