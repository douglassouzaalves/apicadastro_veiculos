package br.com.cadastro.veiculos.controller;

import br.com.cadastro.veiculos.model.Veiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes para VeiculoController")
class VeiculoControllerTest {

    @Autowired
    private MockMvc mvc;

    private final String CONTEXTO_VEICULO = "/veiculo";
    private final String CONTEXTO_VEICULO_CALCULA = "/veiculo/calcula";

    private static Veiculo veiculo;

    @BeforeEach
    public void setup() {
        veiculo = new Veiculo();
        veiculo.setNome("Ka");
        veiculo.setModelo("2017");
        veiculo.setMarca("Ford");
        LocalDate dataDeFabricacao = LocalDate.of(2017, Month.AUGUST, 8);
        veiculo.setDataDeFabricacao(dataDeFabricacao);
        veiculo.setCidadeConsumo(new BigDecimal("7"));
        veiculo.setEstradaConsumo(new BigDecimal("5"));
    }


    @Test
    void testPostVeiculo() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(CONTEXTO_VEICULO)
                        .content("{\"nome\":\"Ka\",\"marca\":\"Ford\",\"modelo\":\"2017\",\"" +
                                "dataDeFabricacao\":\"2017-08-08\",\"cidadeConsumo\":7,\"estradaConsumo\":5}")
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Ka"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.marca").value("Ford"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.modelo").value("2017"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dataDeFabricacao").value("2017-08-08"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cidadeConsumo").value(7.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.estradaConsumo").value(5.0));
    }

    @Test
    void testGetVeiculoCalcula() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(CONTEXTO_VEICULO)
                .content("{\"nome\":\"Ka\",\"marca\":\"Ford\",\"modelo\":\"2017\",\"" +
                        "dataDeFabricacao\":\"2017-08-08\",\"cidadeConsumo\":7,\"estradaConsumo\":5}")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

        mvc.perform(MockMvcRequestBuilders.get(CONTEXTO_VEICULO_CALCULA)
                        .param("preco", "5.0")
                        .param("cidade", "13.0")
                        .param("estrada", "20.0")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Ka"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].marca").value("Ford"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].modelo").value("2017"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].dataDeFabricacao").value("2017-08-08"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cidadeConsumo").value(7.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].estradaConsumo").value(5.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantidadeCombustivelGasto").value(5.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].precoTotal").value(12.0));

    }
}