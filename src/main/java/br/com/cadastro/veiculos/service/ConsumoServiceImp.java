package br.com.cadastro.veiculos.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ConsumoServiceImp implements ConsumoService {

    @Override
    public BigDecimal valorTotalAPagar(BigDecimal gasolinaPreco, BigDecimal consumoLitrosGasolina) {
        return gasolinaPreco.multiply(consumoLitrosGasolina);
    }

    @Override
    public BigDecimal totalLitrosUsados(BigDecimal distancia, BigDecimal mediaConsumida) {
        return distancia.divide(mediaConsumida, RoundingMode.HALF_UP);
    }
}
