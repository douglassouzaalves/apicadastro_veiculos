package br.com.cadastro.veiculos.service;

import java.math.BigDecimal;

public interface ConsumoService {

    BigDecimal valorTotalAPagar(BigDecimal gasolinaPreco, BigDecimal consumoGasolina);

    BigDecimal totalUsado(BigDecimal distancia, BigDecimal mediaConsumida);

}
