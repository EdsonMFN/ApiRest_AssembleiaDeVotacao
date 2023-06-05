package desafioTecnico.api.controller;

import desafioTecnico.api.entity.login.DadosCadastroLogin;
import desafioTecnico.api.entity.login.Usuario;
import desafioTecnico.api.security.security.DadosToken;
import desafioTecnico.api.security.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager maneger;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity cadastroLogin (@RequestBody @Valid DadosCadastroLogin dados){

        var authenticationtoken = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());

        var autentication = maneger.authenticate(authenticationtoken);

        var tokenJwt = tokenService.gerarToken((Usuario) authenticationtoken.getPrincipal());

        return ResponseEntity.ok(new DadosToken(tokenJwt));
    }
}
