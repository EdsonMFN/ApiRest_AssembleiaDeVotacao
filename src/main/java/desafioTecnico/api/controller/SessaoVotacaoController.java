package desafioTecnico.api.controller;

import desafioTecnico.api.controller.response.ResponseSessao;
import desafioTecnico.api.controller.resquest.RequestSessao;
import desafioTecnico.api.service.SessaoVotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/sessao")
public class SessaoVotacaoController {

    @Autowired
    private SessaoVotacaoService sessaoVotacaoservice;

    @PostMapping("/{idVoto}/{idPauta}")
    public ResponseEntity<ResponseSessao> criarSessao(@PathVariable Long idVoto, Long idPauta, ResponseSessao responseSessao, LocalDateTime fimVotacao, @RequestBody RequestSessao requestSessao){

        responseSessao = sessaoVotacaoservice.criarSessao(idVoto,idPauta,requestSessao, fimVotacao,responseSessao);

        return ResponseEntity.ok(responseSessao);
    }
}
