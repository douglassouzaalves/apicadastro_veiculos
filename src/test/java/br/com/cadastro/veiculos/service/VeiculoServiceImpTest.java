package br.com.cadastro.veiculos.service;

import br.com.cadastro.veiculos.dto.VeiculoResponse;
import br.com.cadastro.veiculos.mapper.VeiculoMapper;
import br.com.cadastro.veiculos.model.Veiculo;
import br.com.cadastro.veiculos.repository.VeiculoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes para VeiculoServiceImp")
class VeiculoServiceImpTest {

    @InjectMocks
    private VeiculoServiceImp veiculoServiceImp;

    @Mock
    private VeiculoRepository veiculoRepository;

    @Mock
    private VeiculoMapper veiculoMapper;


    @Test
    void test_Insere_Veiculo() {
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


    private Veiculo getVeiculoEntity() {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(UUID.fromString("5eef7e7f-e70a-48b4-9121-1f40e777f77b"));
        veiculo.setNome("Ka");
        veiculo.setMarca("Ford");
        veiculo.setModelo("2017");
        veiculo.setDataDeFabricacao(LocalDate.of(2017, Month.AUGUST, 8));
        veiculo.setEstradaConsumo(new BigDecimal("5"));
        veiculo.setCidadeConsumo(new BigDecimal("7"));
        return veiculo;
    }

    private VeiculoResponse getVeiculoResponse() {

        return new VeiculoResponse(
                UUID.fromString("5eef7e7f-e70a-48b4-9121-1f40e777f77b"),
                "Ka",
                "Ford",
                "2017",
                LocalDate.of(2017, Month.AUGUST, 8),
                new BigDecimal("7"),
                new BigDecimal("5"));
    }

}