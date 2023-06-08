package desafioTecnico.api.repository;

import desafioTecnico.api.entity.pauta.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPauta extends JpaRepository<Pauta,Long> {
}
