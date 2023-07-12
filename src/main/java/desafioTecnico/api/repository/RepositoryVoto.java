package desafioTecnico.api.repository;

import desafioTecnico.api.entity.associado.Associado;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacao;
import desafioTecnico.api.entity.voto.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface RepositoryVoto extends JpaRepository<Voto, Long> {

    Optional<Voto> findById(Long idVoto);

    List<Voto> findBySessaoVotacao(SessaoVotacao sessaoVotacao);

    Voto findByAssociado(Associado cpfAssociado);

    Voto findAllByAssociado(Associado cpfAssociado);

    Voto findBySessaoVotacaoAndAssociado(SessaoVotacao sessaoVotacao, Associado associado);
}
