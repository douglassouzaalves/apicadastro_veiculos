package br.com.cadastro.veiculos.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@DisplayName("Testes para ConsumoServiceImp")
class ConsumoServiceImpTest {

    private static final BigDecimal PRECO_GASOLINA = new BigDecimal("5");
    private static final BigDecimal CONSUMO_GASOLINA = new BigDecimal("10");
    private static final BigDecimal DISTANCIA = new BigDecimal("4");
    private static final BigDecimal MEDIA_CONSUMO = new BigDecimal("2");

    private final ConsumoService consumoService = new ConsumoServiceImp();

    @Test
    void deve_Calcular_Valor_Total_A_Pagar() {
        BigDecimal valorTotalAPagar = consumoService.valorTotalAPagar(PRECO_GASOLINA, CONSUMO_GASOLINA);

        Assertions.assertEquals(new BigDecimal("50"), valorTotalAPagar);
    }

    @Test
    void deve_Calcular_Total_Consumo() {
        BigDecimal consumo = consumoService.totalLitrosUsados(DISTANCIA, MEDIA_CONSUMO);

        Assertions.assertEquals(new BigDecimal("2"), consumo);
    }

}