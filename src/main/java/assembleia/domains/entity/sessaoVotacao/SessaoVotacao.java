package assembleia.domains.entity.sessaoVotacao;

import assembleia.domains.entity.pauta.Pauta;
import assembleia.domains.entity.voto.Voto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Table(name = "sessao_votacao")
@Entity(name = "SessaoVotacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class SessaoVotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sessao_votacao")
    @PrimaryKeyJoinColumns(value = {@PrimaryKeyJoinColumn})
    private Long id;

    @Column(name = "inicio_votacao")
    private LocalDateTime inicioVotacao;

    @Column(name = "fim_votacao")
    private LocalDateTime fimVotacao;

    @OneToOne
    @JoinColumn(name = "id_pauta")
    private Pauta pauta;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sessao_voto_sim")
    private List<Voto> votosSim;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sessao_voto_nao")
    private List<Voto> votosNao;

}
