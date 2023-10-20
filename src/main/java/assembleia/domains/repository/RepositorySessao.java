package assembleia.domains.repository;

import assembleia.domains.entity.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorySessao extends JpaRepository<SessaoVotacao, Long> {

    Optional<SessaoVotacao> findById(Long idSessaoVotacao);
}
