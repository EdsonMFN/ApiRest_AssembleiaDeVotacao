package desafioTecnico.api.repository;

import desafioTecnico.api.entity.associado.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAssociado extends JpaRepository<Associado,Long> {

    Associado findByCpf(String cpf);
}
