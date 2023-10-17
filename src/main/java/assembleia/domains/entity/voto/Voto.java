package assembleia.domains.entity.voto;

import assembleia.domains.entity.associado.Associado;
import assembleia.enums.MensagemVoto;
import assembleia.domains.entity.sessaoVotacao.SessaoVotacao;
import jakarta.persistence.*;
import lombok.*;

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
    @JoinColumn(name = "id_associado")
    private Associado associado;

    @Column(name = "dataHora_voto")
    private LocalDateTime dataHoraVoto;

    @Column(name = "mensagem_voto")
    @Enumerated(EnumType.STRING)
    private MensagemVoto mensagemVoto;

    @ManyToOne
    @JoinColumn(name = "id_sessao_votacao")
    private SessaoVotacao sessaoVotacao;
}