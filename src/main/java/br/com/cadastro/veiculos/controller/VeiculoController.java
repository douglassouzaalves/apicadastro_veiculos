package br.com.cadastro.veiculos.controller;

import br.com.cadastro.veiculos.dto.VeiculoRequest;
import br.com.cadastro.veiculos.dto.VeiculoResponse;
import br.com.cadastro.veiculos.mapper.VeiculoMapper;
import br.com.cadastro.veiculos.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private final VeiculoService veiculoService;

    private final VeiculoMapper veiculoMapper;

    public VeiculoController(VeiculoService veiculoService, VeiculoMapper veiculoMapper) {
        this.veiculoService = veiculoService;
        this.veiculoMapper = veiculoMapper;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public VeiculoResponse insert(@RequestBody VeiculoRequest veiculo) {
        VeiculoResponse salvaVeiculo = veiculoService.insert(veiculoMapper.toEntity(veiculo));
        return salvaVeiculo;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/calcula")
    public List<VeiculoResponse> calcula(@RequestParam("preco") BigDecimal preco, @RequestParam("cidade") BigDecimal cidade, @RequestParam("estrada") BigDecimal estrada) {
        List<VeiculoResponse> dto = veiculoService.somaTotal(preco, cidade, estrada);
        return dto;
    }
}
