package desafioTecnico.api.controller;

import desafioTecnico.api.controller.response.ResponseSessao;
import desafioTecnico.api.controller.resquest.RequestSessao;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacao;
import desafioTecnico.api.service.SessaoVotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessao")
public class SessaoVotacaoController {

    @Autowired
    private SessaoVotacaoService sessaoVotacaoservice;

    @PostMapping("/{idPauta}")
    public ResponseEntity<ResponseSessao> criarSessao(@PathVariable Long idPauta ,@RequestBody RequestSessao requestSessao){

      ResponseSessao  responseSessao = sessaoVotacaoservice.criarSessao(idPauta,requestSessao);

      return ResponseEntity.ok(responseSessao);
    }

    @GetMapping("/{idSessao}")
    public ResponseEntity<ResponseSessao> buscarSessao(@PathVariable Long idSessao){

        ResponseSessao responseSessao = sessaoVotacaoservice.buscarSessao(idSessao);

        return ResponseEntity.ok(responseSessao);
    }

}
