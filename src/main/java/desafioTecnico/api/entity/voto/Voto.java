package desafioTecnico.api.entity.voto;

import desafioTecnico.api.entity.associado.Associado;
import desafioTecnico.api.entity.associado.MensagemVoto;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.ToOne;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;

import java.time.LocalDateTime;

@Table(name = "voto")
@Entity(name = "Voto")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voto")
    @PrimaryKeyJoinColumns(value = {@PrimaryKeyJoinColumn})
    private Long id;

    @OneToMany
    @JoinColumn(name = "id_associado")
    private Associado associado;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "mensagem_voto")
    @Enumerated(EnumType.STRING)
    private MensagemVoto mensagemVoto;

    @ManyToOne
    @JoinColumn(name = "id_sessao_votacao")
    private SessaoVotacao sessaoVotacao;
}