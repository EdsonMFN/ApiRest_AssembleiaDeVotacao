package desafioTecnico.api.entity.voto;

import desafioTecnico.api.entity.associado.Associado;
import desafioTecnico.api.entity.associado.MensagemVoto;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "voto")
@Entity(name = "Voto")
@Getter
@Setter
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

    public Voto(Long id, LocalDateTime dataHoraVoto, MensagemVoto mensagemVoto, SessaoVotacao sessaoVotacao){

        this.id = id;
        this.dataHoraVoto = dataHoraVoto;
        this.mensagemVoto = mensagemVoto;
        this.sessaoVotacao = sessaoVotacao;
    }
}