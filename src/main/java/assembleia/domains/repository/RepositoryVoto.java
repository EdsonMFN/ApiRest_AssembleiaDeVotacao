package assembleia.domains.repository;

import assembleia.domains.entity.Associado;
import assembleia.domains.entity.SessaoVotacao;
import assembleia.domains.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface RepositoryVoto extends JpaRepository<Voto, Long> {

    Optional<Voto> findById(Long idVoto);

    List<Voto> findBySessaoVotacao(SessaoVotacao sessaoVotacao);

    Voto findBySessaoVotacaoAndAssociado(SessaoVotacao sessaoVotacao, Associado associado);
}
