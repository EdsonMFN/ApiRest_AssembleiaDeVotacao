package assembleia.domains.repository;

import assembleia.domains.entity.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPauta extends JpaRepository<Pauta,Long> {
}
