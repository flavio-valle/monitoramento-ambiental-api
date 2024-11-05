package br.com.fiap.monitoramento_ambiental_api.controllers;



import br.com.fiap.monitoramento_ambiental_api.dto.HistoricoAguaDTO;
import br.com.fiap.monitoramento_ambiental_api.model.HistoricoAgua;
import br.com.fiap.monitoramento_ambiental_api.model.MonitoramentoAgua;
import br.com.fiap.monitoramento_ambiental_api.services.HistoricoAguaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historico-agua")
public class HistoricoAguaController {

    @Autowired
    private HistoricoAguaService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<HistoricoAguaDTO> listarTodos() {
        List<HistoricoAgua> lista = service.listarTodos();
        return lista.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public HistoricoAguaDTO buscarPorId(@PathVariable Long id) {
        HistoricoAgua historicoAgua = service.buscarPorId(id);
        return convertToDTO(historicoAgua);
    }

    @PostMapping
    public HistoricoAguaDTO criar(@RequestBody @Valid HistoricoAguaDTO historicoAguaDTO) {
        HistoricoAgua historicoAgua = convertToEntity(historicoAguaDTO);

        // Associar o MonitoramentoAgua se o ID for fornecido
        if (historicoAguaDTO.getMonitoramentoAguaId() != null) {
            MonitoramentoAgua monitoramentoAgua = service.obterMonitoramentoAguaPorId(historicoAguaDTO.getMonitoramentoAguaId());
            historicoAgua.setMonitoramentoAgua(monitoramentoAgua);
        }

        HistoricoAgua criado = service.salvar(historicoAgua);
        return convertToDTO(criado);
    }

    @PutMapping("/{id}")
    public HistoricoAguaDTO atualizar(@PathVariable Long id, @RequestBody @Valid HistoricoAguaDTO historicoAguaDTO) {
        HistoricoAgua historicoAgua = convertToEntity(historicoAguaDTO);
        historicoAgua.setId(id);

        // Associar o MonitoramentoAgua se o ID for fornecido
        if (historicoAguaDTO.getMonitoramentoAguaId() != null) {
            MonitoramentoAgua monitoramentoAgua = service.obterMonitoramentoAguaPorId(historicoAguaDTO.getMonitoramentoAguaId());
            historicoAgua.setMonitoramentoAgua(monitoramentoAgua);
        }

        HistoricoAgua atualizado = service.salvar(historicoAgua);
        return convertToDTO(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // Métodos utilitários para conversão entre Entidade e DTO
    private HistoricoAguaDTO convertToDTO(HistoricoAgua historicoAgua) {
        HistoricoAguaDTO dto = modelMapper.map(historicoAgua, HistoricoAguaDTO.class);
        if (historicoAgua.getMonitoramentoAgua() != null) {
            dto.setMonitoramentoAguaId(historicoAgua.getMonitoramentoAgua().getId());
        }
        return dto;
    }

    private HistoricoAgua convertToEntity(HistoricoAguaDTO dto) {
        return modelMapper.map(dto, HistoricoAgua.class);
    }
}

