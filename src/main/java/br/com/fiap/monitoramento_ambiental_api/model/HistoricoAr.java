package br.com.fiap.monitoramento_ambiental_api.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_historico_ar")
@Data
public class HistoricoAr {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_historico_ar")
    @SequenceGenerator(name = "seq_historico_ar", sequenceName = "SEQ_HISTORICO_AR", allocationSize = 1)
    @Column(name = "id_historico_ar")
    private Long id;

    @Column(name = "dt_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "lc_localizacao", nullable = false, length = 30)
    private String localizacao;

    @Column(name = "qt_monoxido_carbono")
    private Double monoxidoCarbono;

    @Column(name = "qt_ozonio")
    private Double ozonio;

    @Column(name = "qt_dioxido_nitrogenio")
    private Double dioxidoNitrogenio;

    @Column(name = "qt_dioxido_enxofre")
    private Double dioxidoEnxofre;

    @ManyToOne
    @JoinColumn(name = "id_monitoramento_ar")
    private MonitoramentoAr monitoramentoAr;
}
