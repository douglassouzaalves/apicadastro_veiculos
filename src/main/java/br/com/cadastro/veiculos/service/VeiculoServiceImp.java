package br.com.cadastro.veiculos.service;

import br.com.cadastro.veiculos.dto.VeiculoResponse;
import br.com.cadastro.veiculos.mapper.VeiculoMapper;
import br.com.cadastro.veiculos.model.Veiculo;
import br.com.cadastro.veiculos.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImp implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    private final VeiculoMapper veiculoMapper;

    private final ConsumoService consumoService;

    public VeiculoServiceImp(VeiculoRepository veiculoRepository, VeiculoMapper veiculoMapper,
                             ConsumoService consumoService) {
        this.veiculoRepository = veiculoRepository;
        this.veiculoMapper = veiculoMapper;
        this.consumoService = consumoService;
    }

    @Override
    public VeiculoResponse insert(Veiculo veiculo) {
        Veiculo salvaVeiculo = veiculoRepository.save(veiculo);

        return veiculoMapper.toDto(salvaVeiculo);
    }

    @Override
    public List<VeiculoResponse> somaTotal(BigDecimal preco, BigDecimal cidade, BigDecimal distancia) {
        List<Veiculo> listaVeiculos = veiculoRepository.findAll();

        List<VeiculoResponse> calculaVeiculos = listaVeiculos.stream().map(veiculo -> {
            //BigDecimal consumoEstrada2 = consumoService.totalUsado(veiculo.getEstradaConsumo(),)
            BigDecimal consumoEstrada = consumoService.totalUsado(distancia, veiculo.getEstradaConsumo());
            BigDecimal consumoCidade = consumoService.totalUsado(cidade, veiculo.getCidadeConsumo());
            BigDecimal precoTotal = consumoService.valorTotalAPagar(preco, (consumoCidade.add(consumoEstrada)));

            VeiculoResponse veiculoResponse = veiculoMapper.toDto(veiculo);
            veiculoResponse.setTotal(precoTotal);
            veiculoResponse.setCombustivelConsumido(consumoCidade.add(consumoEstrada));

            return veiculoResponse;
        }).collect(Collectors.toList());

        Collections.sort(calculaVeiculos);

        return calculaVeiculos;
    }

}
