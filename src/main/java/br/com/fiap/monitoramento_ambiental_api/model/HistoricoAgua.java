package br.com.fiap.monitoramento_ambiental_api.model;

import br.com.fiap.monitoramento_ambiental_api.model.MonitoramentoAgua;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_historico_agua")
@Data
public class HistoricoAgua {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_historico_agua")
    @SequenceGenerator(name = "seq_historico_agua", sequenceName = "SEQ_HISTORICO_AGUA", allocationSize = 1)
    @Column(name = "id_historico_agua")
    private Long id;

    @Column(name = "dt_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "lc_localizacao", nullable = false, length = 30)
    private String localizacao;

    @Column(name = "qt_ph")
    private Double ph;

    @Column(name = "qt_oxigenio_dissolvido")
    private Double oxigenioDissolvido;

    @Column(name = "qt_turbidez")
    private Double turbidez;

    @Column(name = "qt_coliformes_totais")
    private Double coliformesTotais;

    @Column(name = "qt_fosforo_total")
    private Double fosforoTotal;

    @ManyToOne
    @JoinColumn(name = "id_monitoramento_agua")
    private MonitoramentoAgua monitoramentoAgua;
}
