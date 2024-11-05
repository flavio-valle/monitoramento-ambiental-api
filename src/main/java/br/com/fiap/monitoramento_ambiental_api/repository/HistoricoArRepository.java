package br.com.fiap.monitoramento_ambiental_api.repository;

import br.com.fiap.monitoramento_ambiental_api.model.HistoricoAr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoArRepository extends JpaRepository<HistoricoAr, Long> {
}

