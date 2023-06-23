package desafioTecnico.api.repository;

import desafioTecnico.api.entity.voto.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RepositoryVoto extends JpaRepository<Voto, Long> {

    Optional<Voto> findById(Long idVoto);
}
