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
    public ResponseEntity<ResponseSessao> criarSessao(@PathVariable Long idPauta){

      ResponseSessao  responseSessaoCriar = sessaoVotacaoservice.criarSessao(idPauta);

      return ResponseEntity.ok(responseSessaoCriar);
    }

    @GetMapping("/{idSessaoVotacao}")
    public ResponseEntity<ResponseSessao> buscarSessao(@PathVariable Long idSessaoVotacao){

        ResponseSessao responseSessaoBuscar = sessaoVotacaoservice.buscarSessao(idSessaoVotacao);

        return ResponseEntity.ok(responseSessaoBuscar);
    }
    @GetMapping
    public ResponseEntity<List<ResponseSessao>> listarSessaoVotacao(){

        List<ResponseSessao> responseSessaoListar = sessaoVotacaoservice.listarSessoes();

        return ResponseEntity.ok(responseSessaoListar);
    }
    @DeleteMapping("/{idSessaoVotacao}")
    public ResponseEntity<ResponseSessao> deletarSessao(@PathVariable Long idSessaoVotacao){

        ResponseSessao responseSessaoDeletar = sessaoVotacaoservice.deletarSessaoVotacao(idSessaoVotacao);

        return ResponseEntity.ok(responseSessaoDeletar);
    }
}
