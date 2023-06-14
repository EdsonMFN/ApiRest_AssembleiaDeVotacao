package desafioTecnico.api.repository;

import desafioTecnico.api.entity.voto.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioVoto extends JpaRepository<Voto, Long> {
}
