package br.com.cadastro.veiculos.service;

import br.com.cadastro.veiculos.dto.CalculoCombustivelResponse;
import br.com.cadastro.veiculos.dto.VeiculoResponse;
import br.com.cadastro.veiculos.mapper.VeiculoMapper;
import br.com.cadastro.veiculos.model.Veiculo;
import br.com.cadastro.veiculos.repository.VeiculoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class VeiculoServiceImpTest {

    @InjectMocks
    private VeiculoServiceImp veiculoServiceImp;

    @Mock
    private VeiculoRepository veiculoRepository;

    @Mock
    private ConsumoService consumoService;

    @Mock
    private VeiculoMapper veiculoMapper;


    @Test
    public void testShouldInsertVehicle() {
        Veiculo veiculoMock = getVeiculoEntity();
        VeiculoResponse veiculoResponseMock = getVeiculoResponse();
        Mockito.when(veiculoRepository.save(veiculoMock)).thenReturn(veiculoMock);
        Mockito.when(veiculoMapper.toDto(veiculoMock)).thenReturn(veiculoResponseMock);

        VeiculoResponse veiculoResponse = veiculoServiceImp.insert(veiculoMock);

        assertEquals(veiculoMock.getId(), veiculoResponse.getId());
        assertEquals(veiculoMock.getNome(), veiculoResponse.getNome());
        assertEquals(veiculoMock.getMarca(), veiculoResponse.getMarca());
        assertEquals(veiculoMock.getModelo(), veiculoResponse.getModelo());
        assertEquals(veiculoMock.getDataDeFabricacao(), veiculoResponse.getDataDeFabricacao());
        assertEquals(veiculoMock.getEstradaConsumo(), veiculoResponse.getEstradaConsumo());
        assertEquals(veiculoMock.getCidadeConsumo(), veiculoResponse.getCidadeConsumo());
    }

    @Test
    public void testShouldComputeVehicles() {
        Veiculo veiculoMock = getVeiculoEntity();
        VeiculoResponse veiculoResponseMock = getVeiculoResponse();
        List<Veiculo> allVeiculos = new ArrayList<>();
        allVeiculos.add(veiculoMock);
        BigDecimal estrada = new BigDecimal("7");
        BigDecimal cidade = new BigDecimal("5");
        BigDecimal preco = new BigDecimal("5");
        Mockito.when(veiculoRepository.save(veiculoMock)).thenReturn(veiculoMock);
        Mockito.when(veiculoMapper.toDto(veiculoMock)).thenReturn(veiculoResponseMock);
        Mockito.when(veiculoRepository.findAll()).thenReturn(allVeiculos);
        Mockito.when(consumoService.totalLitrosUsados(estrada, veiculoMock.getEstradaConsumo())).thenReturn(new BigDecimal("7"));
        Mockito.when(consumoService.totalLitrosUsados(cidade, veiculoMock.getCidadeConsumo())).thenReturn(new BigDecimal("5"));
        Mockito.when(consumoService.valorTotalAPagar(preco, new BigDecimal("12"))).thenReturn(new BigDecimal("10"));

//        List<VeiculoResponse> getVeiculos = veiculoServiceImp.somaTotal(new BigDecimal(""), );
//        List<CalculoCombustivelResponse> calculaValorGastoVeiculos = consumoService.valorTotalAPagar();
//        assertEquals(1, calculaValorGastoVeiculos.size());
//        assertEquals(veiculoMock.getNome(), getVeiculos.get(0).getNome());
//        assertEquals(veiculoMock.getMarca(), getVeiculos.get(0).getMarca());
//        assertEquals(veiculoMock.getModelo(), getVeiculos.get(0).getModelo());
//        assertEquals(veiculoMock.getDataDeFabricacao(), getVeiculos.get(0).getDataDeFabricacao());
//        assertEquals(veiculoMock.getEstradaConsumo(), getVeiculos.get(0).getEstradaConsumo());
//        assertEquals(veiculoMock.getCidadeConsumo(), getVeiculos.get(0).getCidadeConsumo());
//        assertEquals(7.0f, calculaValorGastoVeiculos.get(0).getValorTotalGastoCombustivel(), 0.0001);
//        assertEquals(35.0f, calculaValorGastoVeiculos.get(0).getValorTotalGastoCombustivel(), 0.0001);
    }

    private Veiculo getVeiculoEntity() {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(UUID.fromString("0000-0000-0000-0000"));
        veiculo.setNome("Ka");
        veiculo.setMarca("Ford");
        veiculo.setModelo("2017");
        veiculo.setDataDeFabricacao(LocalDate.of(2017, Month.AUGUST, 8));
        veiculo.setEstradaConsumo(new BigDecimal("5"));
        veiculo.setCidadeConsumo(new BigDecimal("7"));
        return veiculo;
    }

    private VeiculoResponse getVeiculoResponse() {
        VeiculoResponse veiculo = new VeiculoResponse(
                UUID.fromString("0000-0000-0000-0000"),
                "Ford",
                "Ka",
                "2017",
                LocalDate.of(2017, Month.AUGUST, 8),
                5.0f,
                5.0f);

        return veiculo;
    }

}