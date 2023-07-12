package desafioTecnico.api.controller;

import desafioTecnico.api.controller.response.ResponseVoto;
import desafioTecnico.api.controller.resquest.RequestVoto;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacao;
import desafioTecnico.api.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping("/{idSessaoVotacao}/{cpfAssociado}")
    public ResponseEntity<ResponseVoto> criarVoto (@PathVariable Long idSessaoVotacao,@PathVariable String cpfAssociado ,@RequestBody RequestVoto requestVoto){

      ResponseVoto responseVotoCriar = votoService.criarVoto(idSessaoVotacao,cpfAssociado,requestVoto);

      return ResponseEntity.ok(responseVotoCriar);
    }

    @GetMapping("/{idSessaoVotacao}")
    public ResponseEntity<ResponseVoto> listarVoto(@PathVariable Long idSessaoVotacao){

        ResponseVoto responseVotoListar = votoService.listagemVoto(idSessaoVotacao);

        return ResponseEntity.ok(responseVotoListar);
    }

    @GetMapping("/{cpfAssociado}/{idSessaoVotacao}")
    public ResponseEntity<ResponseVoto> buscarDadosAssociado (@PathVariable String cpfAssociado, @PathVariable Long idSessaoVotacao){

        ResponseVoto responseVotoBuscar = votoService.buscarDadosAssociado(cpfAssociado,idSessaoVotacao);

        return ResponseEntity.ok(responseVotoBuscar);
    }
    @DeleteMapping("/{idSessaoVotacao}/{cpfAssociado}")
    public ResponseEntity<ResponseVoto> deletarVoto(@PathVariable Long idSessaoVotacao, @PathVariable String cpfAssociado){

        ResponseVoto responseVotoDeletar = votoService.deletarVoto(idSessaoVotacao, cpfAssociado);

        return ResponseEntity.ok(responseVotoDeletar);
    }
}
