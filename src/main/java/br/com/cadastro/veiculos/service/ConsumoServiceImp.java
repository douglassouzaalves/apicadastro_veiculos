package br.com.cadastro.veiculos.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConsumoServiceImp implements ConsumoService{

    @Override
    public BigDecimal valorTotalAPagar(BigDecimal gasolinaPreco, BigDecimal consumoLitrosGasolina) {
        gasolinaPreco = new BigDecimal("6.00");
        BigDecimal b1 = null;
        return b1.add(gasolinaPreco.add(consumoLitrosGasolina));
    }

    @Override
    public BigDecimal totalUsado(BigDecimal distancia, BigDecimal mediaConsumida) {
        return distancia.divide(mediaConsumida);
    }
}
