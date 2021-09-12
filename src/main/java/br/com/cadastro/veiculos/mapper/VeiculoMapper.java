package br.com.cadastro.veiculos.mapper;

import br.com.cadastro.veiculos.dto.VeiculoRequest;
import br.com.cadastro.veiculos.dto.VeiculoResponse;
import br.com.cadastro.veiculos.model.Veiculo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoMapper {
    private Veiculo mapToEntity(VeiculoRequest dto) {
        return new Veiculo(
                dto.getId(),
                dto.getNome(),
                dto.getMarca(),
                dto.getModelo(),
                dto.getDataDeFabricacao(),
                dto.getCidadeConsumo(),
                dto.getEstradaConsumo()
        );
    }

    private VeiculoResponse mapToDto(Veiculo entity) {
        return new VeiculoResponse(
                entity.getId(),
                entity.getNome(),
                entity.getMarca(),
                entity.getModelo(),
                entity.getDataDeFabricacao(),
                entity.getCidadeConsumo(),
                entity.getEstradaConsumo()
        );
    }

    private List<Veiculo> mapToListEntity(List<VeiculoRequest> dtos) {
        return dtos.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

    private List<VeiculoResponse> mapToListDto(List<Veiculo> entities) {
        return entities.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Veiculo toEntity(VeiculoRequest dto) {
        return Optional.ofNullable(dto)
                .map(this::mapToEntity)
                .orElse(null);
    }

    public VeiculoResponse toDto(Veiculo entity) {
        return Optional.ofNullable(entity)
                .map(this::mapToDto)
                .orElse(null);
    }

    public List<Veiculo> toListEntity(List<VeiculoRequest> dtos) {
        return Optional.ofNullable(dtos)
                .map(this::mapToListEntity)
                .orElse(null);
    }

    public List<VeiculoResponse> toListDto(List<Veiculo> entities) {
        return Optional.ofNullable(entities)
                .map(this::mapToListDto)
                .orElse(null);
    }

}
