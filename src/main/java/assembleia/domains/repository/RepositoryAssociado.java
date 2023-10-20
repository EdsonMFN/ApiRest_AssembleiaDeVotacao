package assembleia.domains.repository;

import assembleia.domains.entity.Associado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryAssociado extends JpaRepository<Associado,Long> {

    Associado findByCpf(String cpf);
}
