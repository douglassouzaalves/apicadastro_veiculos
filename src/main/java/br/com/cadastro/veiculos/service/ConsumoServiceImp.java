package br.com.cadastro.veiculos.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConsumoServiceImp implements ConsumoService{
    @Override
    public BigDecimal valorTotalAPagar(BigDecimal gasolinaPreco, BigDecimal consumoGasolina) {
        BigDecimal b1 = null;
        return b1.add(gasolinaPreco.add(consumoGasolina));
    }

    @Override
    public BigDecimal totalUsado(BigDecimal distancia, BigDecimal mediaConsumida) {
        return distancia.divide(mediaConsumida);
    }
}
