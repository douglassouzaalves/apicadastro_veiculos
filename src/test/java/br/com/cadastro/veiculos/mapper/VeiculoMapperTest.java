package br.com.cadastro.veiculos.mapper;

import br.com.cadastro.veiculos.dto.VeiculoRequest;
import br.com.cadastro.veiculos.dto.VeiculoResponse;
import br.com.cadastro.veiculos.model.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

class VeiculoMapperTest {

    private static final UUID ID = UUID.fromString("4eef4e4f-e70a-48b4-8621-1f40e611f88b");
    private static final String NOME = "Ford";
    private static final String MARCA = "Ka";
    private static final String MODELO = "2017";
    private static final LocalDate DATA_FABRICACAO = LocalDate.of(2016, 8, 8);
    private static final BigDecimal CIDADE_CONSUMO = new BigDecimal("7");
    private static final BigDecimal ESTRADA_CONSUMO = new BigDecimal("5");

    private final VeiculoMapper veiculoMapper = new VeiculoMapper();

    @Test
    public void deve_Mapear_Para_ToDto() {
        Veiculo entity = new Veiculo(
                ID,
                NOME,
                MARCA,
                MODELO,
                DATA_FABRICACAO,
                CIDADE_CONSUMO,
                ESTRADA_CONSUMO
        );

        VeiculoResponse dto = veiculoMapper.toDto(entity);

        Assertions.assertEquals(ID, dto.getId());
        Assertions.assertEquals(NOME, dto.getNome());
        Assertions.assertEquals(MARCA, dto.getMarca());
        Assertions.assertEquals(MODELO, dto.getModelo());
        Assertions.assertEquals(DATA_FABRICACAO, dto.getDataDeFabricacao());
        Assertions.assertEquals(CIDADE_CONSUMO, dto.getCidadeConsumo());
        Assertions.assertEquals(ESTRADA_CONSUMO, dto.getEstradaConsumo());
    }

    @Test
    public void deve_Mapear_ParaEntity() {
        VeiculoRequest dto = new VeiculoRequest(
                ID,
                NOME,
                MARCA,
                MODELO,
                DATA_FABRICACAO,
                CIDADE_CONSUMO,
                ESTRADA_CONSUMO
        );

        Veiculo entity = veiculoMapper.toEntity(dto);

        Assertions.assertEquals(ID, entity.getId());
        Assertions.assertEquals(NOME, entity.getNome());
        Assertions.assertEquals(MARCA, entity.getMarca());
        Assertions.assertEquals(MODELO, entity.getModelo());
        Assertions.assertEquals(DATA_FABRICACAO, entity.getDataDeFabricacao());
        Assertions.assertEquals(CIDADE_CONSUMO, entity.getCidadeConsumo());
        Assertions.assertEquals(ESTRADA_CONSUMO, entity.getEstradaConsumo());

    }

    @Test
    public void _test_Deve_Mapear_ListDto() {
        List<Veiculo> entityList = Collections.singletonList(
                new Veiculo(
                        ID,
                        NOME,
                        MARCA,
                        MODELO,
                        DATA_FABRICACAO,
                        CIDADE_CONSUMO,
                        ESTRADA_CONSUMO
                )
        );

        List<VeiculoResponse> dtoList = veiculoMapper.toListDto(entityList);

        Assertions.assertEquals(1, dtoList.size());
        VeiculoResponse dto = dtoList.get(0);
        Assertions.assertEquals(ID, dto.getId());
        Assertions.assertEquals(NOME, dto.getNome());
        Assertions.assertEquals(MARCA, dto.getMarca());
        Assertions.assertEquals(MODELO, dto.getModelo());
        Assertions.assertEquals(DATA_FABRICACAO, dto.getDataDeFabricacao());
        Assertions.assertEquals(CIDADE_CONSUMO, dto.getCidadeConsumo());
        Assertions.assertEquals(ESTRADA_CONSUMO, dto.getEstradaConsumo());
    }

    @Test
    public void test_Deve_Mapear_ListEntity() {
        List<VeiculoRequest> dtoList = Collections.singletonList(
                new VeiculoRequest(
                        ID,
                        NOME,
                        MARCA,
                        MODELO,
                        DATA_FABRICACAO,
                        CIDADE_CONSUMO,
                        ESTRADA_CONSUMO
                )
        );

        List<Veiculo> entityList = veiculoMapper.toListEntity(dtoList);

        Assertions.assertEquals(1, entityList.size());
        Veiculo entity = entityList.get(0);
        Assertions.assertEquals(ID, entity.getId());
        Assertions.assertEquals(NOME, entity.getNome());
        Assertions.assertEquals(MARCA, entity.getMarca());
        Assertions.assertEquals(MODELO, entity.getModelo());
        Assertions.assertEquals(DATA_FABRICACAO, entity.getDataDeFabricacao());
        Assertions.assertEquals(CIDADE_CONSUMO, entity.getCidadeConsumo());
        Assertions.assertEquals(ESTRADA_CONSUMO, entity.getEstradaConsumo());
    }

    @Test
    public void test_toEntity_Quando_for_Nulo() {
        var entity = veiculoMapper.toEntity(null);

        Assertions.assertNull(entity);
    }

    @Test
    public void test_toDto_Quando_For_Nulo() {
        var dto = veiculoMapper.toDto(null);

        Assertions.assertNull(dto);
    }

    @Test
    public void test_toListEntity_Quando_For_Nulo() {
        var entity = veiculoMapper.toListEntity(null);

        Assertions.assertNull(entity);
    }

    @Test
    public void test_toListDto_Quando_For_nulo() {
        var dto = veiculoMapper.toListDto(null);

        Assertions.assertNull(dto);
    }

}