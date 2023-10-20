package assembleia.rest.controller;


import assembleia.service.AssociadoService;
import assembleia.rest.response.ResponseAssociado;
import assembleia.rest.resquest.RequestAssociado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/associado")
public class AssociadoController {
    @Autowired
    private AssociadoService associadoService;

    @PostMapping
    public ResponseEntity<ResponseAssociado> criarAssociado(@RequestBody RequestAssociado requestAssociado){

        ResponseAssociado responseAssociadoCriar = associadoService.criarAssociado(requestAssociado);

        return ResponseEntity.ok(responseAssociadoCriar);
    }
    @GetMapping("/cpf/{cpfAssociado}")
    public ResponseEntity<ResponseAssociado> buscarAssociado(@PathVariable String cpfAssociado){

        ResponseAssociado responseAssociadoCriar = associadoService.buscarAssociado(cpfAssociado);

        return ResponseEntity.ok(responseAssociadoCriar);
    }
    @GetMapping
    public ResponseEntity<List<ResponseAssociado>> listarAssociado(){

        List<ResponseAssociado> responseAssociados = associadoService.listarAssociado();

        return ResponseEntity.ok(responseAssociados);
    }
    @PutMapping("/{idAssociado}")
    public ResponseEntity<ResponseAssociado> alterarAssociado(@PathVariable String cpfAssociado, @RequestBody RequestAssociado requestAssociado){

        ResponseAssociado responseAssociadoAlterar = associadoService.alterarAssociado(cpfAssociado,requestAssociado);

        return ResponseEntity.ok(responseAssociadoAlterar);
    }
    @DeleteMapping("/cpf/{cpfAssociado}")
    public ResponseEntity<String> deletarAssociado(@PathVariable String cpfAssociado){

        String responseAssociado = associadoService.deletarAssociado(cpfAssociado);

        return ResponseEntity.ok(responseAssociado);
    }
}
