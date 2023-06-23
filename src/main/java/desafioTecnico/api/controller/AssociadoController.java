package desafioTecnico.api.controller;

import desafioTecnico.api.controller.response.ResponseAssociado;
import desafioTecnico.api.controller.resquest.RequestAssociado;
import desafioTecnico.api.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @PostMapping
    public ResponseEntity<ResponseAssociado> criarAssociado(@RequestBody RequestAssociado requestAssociado){

       ResponseAssociado responseAssociado = associadoService.criarAssociado(requestAssociado);

        return ResponseEntity.ok(responseAssociado);
    }

}
