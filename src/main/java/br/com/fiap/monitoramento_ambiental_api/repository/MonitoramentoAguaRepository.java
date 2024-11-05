package br.com.fiap.monitoramento_ambiental_api.repository;

import br.com.fiap.monitoramento_ambiental_api.model.MonitoramentoAgua;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoramentoAguaRepository extends JpaRepository<MonitoramentoAgua, Long> {
}

