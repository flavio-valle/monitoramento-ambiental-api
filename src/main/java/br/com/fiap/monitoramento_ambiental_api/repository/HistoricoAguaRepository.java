package br.com.fiap.monitoramento_ambiental_api.repository;


import br.com.fiap.monitoramento_ambiental_api.model.HistoricoAgua;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoAguaRepository extends JpaRepository<HistoricoAgua, Long> {
}


