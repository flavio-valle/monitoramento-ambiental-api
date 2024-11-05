package br.com.fiap.monitoramento_ambiental_api.repository;


import br.com.fiap.monitoramento_ambiental_api.model.MonitoramentoAr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoramentoArRepository extends JpaRepository<MonitoramentoAr, Long> {
}

