package desafioTecnico.api.repository;

import desafioTecnico.api.entity.login.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String login);
}
