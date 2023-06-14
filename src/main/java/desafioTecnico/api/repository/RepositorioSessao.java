package desafioTecnico.api.repository;

import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioSessao extends JpaRepository<SessaoVotacao, Long> {
}
