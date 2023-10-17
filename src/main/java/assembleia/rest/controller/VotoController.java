package assembleia.rest.controller;

import assembleia.service.VotoService;
import assembleia.rest.response.ResponseVoto;
import assembleia.rest.resquest.RequestVoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping("/sessao/{idSessaoVotacao}/associado/{cpfAssociado}")
    public ResponseEntity<ResponseVoto> criarVoto (@PathVariable Long idSessaoVotacao,@PathVariable String cpfAssociado ,@RequestBody RequestVoto requestVoto){

      ResponseVoto responseVotoCriar = votoService.criarVoto(idSessaoVotacao,cpfAssociado,requestVoto);

      return ResponseEntity.ok(responseVotoCriar);
    }

    @GetMapping("/sessao/{idSessaoVotacao}")
    public ResponseEntity<ResponseVoto> listarVoto(@PathVariable Long idSessaoVotacao){

        ResponseVoto responseVotoListar = votoService.listagemVoto(idSessaoVotacao);

        return ResponseEntity.ok(responseVotoListar);
    }

    @GetMapping("/associado/{cpfAssociado}/sessao/{idSessaoVotacao}")
    public ResponseEntity<ResponseVoto> buscarDadosAssociado (@PathVariable String cpfAssociado, @PathVariable Long idSessaoVotacao){

        ResponseVoto responseVotoBuscar = votoService.buscarDadosAssociado(cpfAssociado,idSessaoVotacao);

        return ResponseEntity.ok(responseVotoBuscar);
    }
}
