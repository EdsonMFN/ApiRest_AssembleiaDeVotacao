package desafioTecnico.api.security.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import desafioTecnico.api.entity.login.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario){

        try {
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("desafio_tecnico")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(ExpiracaoToken())
                    .sign(algoritimo);
        } catch (JWTCreationException exception){
            throw  new RuntimeException("Erro ao gerar o token", exception);
        }
    }

    private Instant ExpiracaoToken() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
