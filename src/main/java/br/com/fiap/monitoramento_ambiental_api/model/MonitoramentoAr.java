package br.com.fiap.monitoramento_ambiental_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_monitoramento_ar")
@Data
public class MonitoramentoAr {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_monitoramento_ar")
    @SequenceGenerator(name = "seq_monitoramento_ar", sequenceName = "SEQ_MONITORAMENTO_AR", allocationSize = 1)
    @Column(name = "id_monitoramento_ar")
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
}


