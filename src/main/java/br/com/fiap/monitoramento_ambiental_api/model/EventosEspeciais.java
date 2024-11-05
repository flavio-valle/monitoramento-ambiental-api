package br.com.fiap.monitoramento_ambiental_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_eventos_especiais")
@Data
public class EventosEspeciais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_eventos_especiais")
    @SequenceGenerator(name = "seq_eventos_especiais", sequenceName = "SEQ_EVENTOS_ESPECIAIS", allocationSize = 1)
    @Column(name = "id_evento")
    private Long id;

    @Column(name = "medicao", nullable = false)
    private Double medicao;

    @Column(name = "dt_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "id_atributo", nullable = false)
    private Integer idAtributo;

    @ManyToOne
    @JoinColumn(name = "id_historico_ar")
    private HistoricoAr historicoAr;

    @ManyToOne
    @JoinColumn(name = "id_historico_agua")
    private HistoricoAgua historicoAgua;
}

