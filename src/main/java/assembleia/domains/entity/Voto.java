package assembleia.domains.entity;

import assembleia.enums.MensagemVoto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "voto")
@Entity(name = "Voto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voto")
    @PrimaryKeyJoinColumns(value = {@PrimaryKeyJoinColumn})
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_associado",nullable = false)
    private Associado associado;

    @Column(name = "dataHora_voto",nullable = false)
    private LocalDateTime dataHoraVoto;

    @Column(name = "mensagem_voto",nullable = false)
    @Enumerated(EnumType.STRING)
    private MensagemVoto mensagemVoto;

    @ManyToOne
    @JoinColumn(name = "id_sessao_votacao",nullable = false)
    private SessaoVotacao sessaoVotacao;
}