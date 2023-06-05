package desafioTecnico.api.repository;

import desafioTecnico.api.entity.associado.Associado;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Arrays;

public interface RepositoryAssociado extends JpaRepository<Associado,Long> {
}
