package assembleia.rest.controller;

import assembleia.service.PautaService;
import assembleia.rest.response.ResponsePauta;
import assembleia.rest.resquest.RequestPauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pauta")
public class PautaController {

    @Autowired
    private PautaService pautaService;

    @PostMapping
    public ResponseEntity<ResponsePauta> criarPauta(@RequestBody RequestPauta requestPauta ) {

        ResponsePauta responsePauta = pautaService.criarPauta(requestPauta);

        return ResponseEntity.ok(responsePauta);
    }
    @GetMapping("/{idPauta}")
    public ResponseEntity<ResponsePauta> buscarPauta(@PathVariable Long idPauta){

        ResponsePauta responsePautaCriar = pautaService.buscarPauta(idPauta);

        return ResponseEntity.ok(responsePautaCriar);
    }
    @GetMapping
    public ResponseEntity<List<ResponsePauta>> listarPauta(){

        List<ResponsePauta> responsePautaLista = pautaService.listarPauta();

        return ResponseEntity.ok(responsePautaLista);
    }
    @DeleteMapping("/{idPauta}")
    public ResponseEntity deletarPauta(@PathVariable Long idPauta){

        pautaService.deletarPauta(idPauta);

        return ResponseEntity.ok("Pauta deletada com sucesso");
    }
}