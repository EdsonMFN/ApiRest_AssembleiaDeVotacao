package desafioTecnico.api.controller;

import desafioTecnico.api.controller.response.ResponseAssociado;
import desafioTecnico.api.controller.resquest.RequestAssociado;
import desafioTecnico.api.entity.associado.Associado;
import desafioTecnico.api.entity.associado.DadosAtualizacaoAssociado;
import desafioTecnico.api.entity.associado.DadosCadastroAssociado;
import desafioTecnico.api.entity.associado.ListaAssociado;
import desafioTecnico.api.repository.RepositoryAssociado;
import desafioTecnico.api.service.AssociadoService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ResponseAssociado> criarAssociado(@PathVariable Long idVoto, ResponseAssociado responseAssociado, @RequestBody RequestAssociado requestAssociado){

        responseAssociado = associadoService.criarAssociado(idVoto, requestAssociado, responseAssociado);

        return ResponseEntity.ok(responseAssociado);
    }

}
