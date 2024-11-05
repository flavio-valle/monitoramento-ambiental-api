package br.com.fiap.monitoramento_ambiental_api.services;



import br.com.fiap.monitoramento_ambiental_api.model.MonitoramentoAr;
import br.com.fiap.monitoramento_ambiental_api.repository.MonitoramentoArRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoramentoArService {

    @Autowired
    private MonitoramentoArRepository repository;

    public List<MonitoramentoAr> listarTodos() {
        return repository.findAll();
    }

    public MonitoramentoAr buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public MonitoramentoAr salvar(MonitoramentoAr monitoramentoAr) {
        return repository.save(monitoramentoAr);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
