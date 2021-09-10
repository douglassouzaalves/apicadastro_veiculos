package br.com.cadastro.veiculos.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;



@Entity
public class Veiculo {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", updatable = false, nullable = false)
    @ColumnDefault("random_uuid()")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "data_fabricacao")
    private LocalDate dataDeFabricacao;

    @Column(name = "cidade_consumo")
    private BigDecimal cidadeConsumo;

    @Column(name = "estrada_consumo")
    private BigDecimal estradaConsumo;

    public Veiculo() {
    }

    public Veiculo(UUID id, String nome, String marca, String modelo,
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

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String make) {
        this.marca = make;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String model) {
        this.modelo = model;
    }

    public LocalDate getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    public void setDataDeFabricacao(LocalDate manufactureDate) {
        this.dataDeFabricacao = manufactureDate;
    }

    public BigDecimal getCidadeConsumo() {
        return cidadeConsumo;
    }

    public void setCidadeConsumo(BigDecimal cityConsumption) {
        this.cidadeConsumo = cityConsumption;
    }

    public BigDecimal getEstradaConsumo() {
        return estradaConsumo;
    }

    public void setEstradaConsumo(BigDecimal highwayConsumption) {
        this.estradaConsumo = highwayConsumption;
    }
}

