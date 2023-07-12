package desafioTecnico.api.controller;


import desafioTecnico.api.controller.response.ResponseAssociado;
import desafioTecnico.api.controller.resquest.RequestAssociado;
import desafioTecnico.api.service.AssociadoService;
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
    @GetMapping("/{cpfAssociado}")
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
    public ResponseEntity<ResponseAssociado> alterarAssociado(@PathVariable Long idAssociado, @RequestBody RequestAssociado requestAssociado){

        ResponseAssociado responseAssociadoAlterar = associadoService.alterarAssociado(idAssociado,requestAssociado);

        return ResponseEntity.ok(responseAssociadoAlterar);
    }
    @DeleteMapping("/{cpfAssociado}")
    public ResponseEntity<ResponseAssociado> deletarAssociado(@PathVariable String cpfAssociado){

        ResponseAssociado responseAssociadoDeletar = associadoService.deletarAssociado(cpfAssociado);

        return ResponseEntity.ok(responseAssociadoDeletar);
    }
}
