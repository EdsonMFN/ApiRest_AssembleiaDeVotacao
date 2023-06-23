package desafioTecnico.api.controller;

import desafioTecnico.api.controller.response.ResponseVoto;
import desafioTecnico.api.controller.resquest.RequestVoto;
import desafioTecnico.api.entity.voto.Voto;
import desafioTecnico.api.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping("/{idSessaoVotacao}")
    public ResponseEntity<ResponseVoto> criarVoto (@PathVariable Long idSessaoVotacao, ResponseVoto responseVoto, @RequestBody RequestVoto requestVoto){

        responseVoto = votoService.criarVoto(idSessaoVotacao, responseVoto,requestVoto);

        return ResponseEntity.ok(responseVoto);
    }
}
