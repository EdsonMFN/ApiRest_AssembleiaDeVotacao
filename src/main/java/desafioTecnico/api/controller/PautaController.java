package desafioTecnico.api.controller;

import desafioTecnico.api.controller.response.ResponsePauta;
import desafioTecnico.api.controller.resquest.RequestPauta;
import desafioTecnico.api.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pauta")
public class PautaController {

    @Autowired
    private PautaService pautaService;

    @PostMapping
    public ResponseEntity<ResponsePauta> criarPauta(ResponsePauta responsePauta, @RequestBody RequestPauta requestPauta) {

        responsePauta = pautaService.criarPauta(responsePauta, requestPauta);

        return ResponseEntity.ok(responsePauta);
    }

}