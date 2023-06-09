package desafioTecnico.api.entity.sessaoVotacao;

import desafioTecnico.api.entity.pauta.Pauta;
import desafioTecnico.api.entity.voto.Voto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;

@Table(name = "sessao_votacao")
@Entity(name = "Sessao_votacao")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class SessaoVotacao {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @PrimaryKeyJoinColumns(value = {@PrimaryKeyJoinColumn})
    private Long id;

    @Column(name = "inicio_votacao")
    private LocalDateTime inicioVotacao;

    @Column(name = "fim_votacao")
    private LocalDateTime fimVotacao;

    @ManyToOne
    @JoinColumn(name = "id_pauta")
    private Pauta pauta;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "sessaoVotacao", cascade = CascadeType.ALL)
    private Collection<Voto> voto = new LinkedHashSet<Voto>();

}
