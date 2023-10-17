package assembleia.domains.repository;

import assembleia.domains.entity.associado.Associado;
import assembleia.domains.entity.sessaoVotacao.SessaoVotacao;
import assembleia.domains.entity.voto.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface RepositoryVoto extends JpaRepository<Voto, Long> {

    Optional<Voto> findById(Long idVoto);

    List<Voto> findBySessaoVotacao(SessaoVotacao sessaoVotacao);

    Voto findBySessaoVotacaoAndAssociado(SessaoVotacao sessaoVotacao, Associado associado);
}
