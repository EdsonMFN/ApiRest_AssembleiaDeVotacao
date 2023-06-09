package desafioTecnico.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessaoVotacao")
public class SessaoVotacaoController {

    @PostMapping("/")
    public ResponseEntity cadastroSessao(@RequestBody@Valid DadosCadastroSessao dados){

        return ResponseEntity.ok().build();
    }
}