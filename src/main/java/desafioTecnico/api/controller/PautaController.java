package desafioTecnico.api.controller;

import desafioTecnico.api.entity.associado.ListaAssociado;
import desafioTecnico.api.entity.pauta.DadosAtualizacaoPauta;
import desafioTecnico.api.entity.pauta.DadosCadastroPauta;
import desafioTecnico.api.entity.pauta.ListaPauta;
import desafioTecnico.api.entity.pauta.Pauta;
import desafioTecnico.api.repository.RepositoryPauta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pauta")
public class PautaController {

    @Autowired
    private RepositoryPauta repositoryPauta;

    @PostMapping
    public ResponseEntity cadastroPauta(@RequestBody@Valid DadosCadastroPauta dados){

        var cadastro = repositoryPauta.save(new Pauta(dados));

        return ResponseEntity.ok(cadastro);
    }

    @GetMapping
    public ResponseEntity <List<ListaPauta>> listagem(){

        var listar = repositoryPauta.findAll().stream().map(ListaPauta::new).toList();

        return ResponseEntity.ok(listar);
    }
    @GetMapping("/{id}")
    public ResponseEntity buscarPauta(@PathVariable Long id){

        var buscar = repositoryPauta.getReferenceById(id);

        return ResponseEntity.ok(new ListaPauta(buscar));
    }

    @PutMapping
    public ResponseEntity atualizarPauta(@RequestBody@Valid DadosAtualizacaoPauta dados){

        var atualizar = repositoryPauta.getReferenceById(dados.id());
        atualizar.atualizarInfoPauta(dados);

        return ResponseEntity.ok(new ListaPauta(atualizar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPauta(@PathVariable Long id){

        repositoryPauta.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
