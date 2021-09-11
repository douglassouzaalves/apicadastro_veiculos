package br.com.cadastro.veiculos.service;

import br.com.cadastro.veiculos.dto.CalculoCombustivelResponse;
import br.com.cadastro.veiculos.dto.VeiculoResponse;
import br.com.cadastro.veiculos.model.Veiculo;


import java.math.BigDecimal;
import java.util.List;

public interface VeiculoService {
    VeiculoResponse insert(Veiculo veiculo);

    List<CalculoCombustivelResponse> somaTotal(BigDecimal preco, BigDecimal cidade, BigDecimal estrada);
}
