package br.com.cadastro.veiculos.service;

import br.com.cadastro.veiculos.dto.CalculoCombustivelResponse;
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
    public List<CalculoCombustivelResponse> somaTotal(BigDecimal preco, BigDecimal distanciaCidade, BigDecimal distanciaEstrada) {
        List<Veiculo> listaVeiculos = veiculoRepository.findAll();

        List<CalculoCombustivelResponse> calculaVeiculos = listaVeiculos.stream().map(veiculo -> {
            BigDecimal consumoEstradaLitros = consumoService.totalLitrosUsados(distanciaEstrada, veiculo.getEstradaConsumo());
            BigDecimal consumoCidadeLitros = consumoService.totalLitrosUsados(distanciaCidade, veiculo.getCidadeConsumo());
            BigDecimal consumoLitrosTotal = consumoCidadeLitros.add(consumoEstradaLitros);
            BigDecimal precoTotal = consumoService.valorTotalAPagar(preco, consumoLitrosTotal);

            CalculoCombustivelResponse calculoCombustivelResponse = new CalculoCombustivelResponse();
            calculoCombustivelResponse.setNome(veiculo.getNome());
            calculoCombustivelResponse.setMarca(veiculo.getMarca());
            calculoCombustivelResponse.setModelo(veiculo.getModelo());
            calculoCombustivelResponse.setDataDeFabricacao(veiculo.getDataDeFabricacao());
            calculoCombustivelResponse.setQuantidadeCombustivelGasto(consumoLitrosTotal);
            calculoCombustivelResponse.setValorTotalGastoCombustivel(precoTotal);

            return calculoCombustivelResponse;
        }).collect(Collectors.toList());

        Collections.sort(calculaVeiculos);

        return calculaVeiculos;
    }

}
