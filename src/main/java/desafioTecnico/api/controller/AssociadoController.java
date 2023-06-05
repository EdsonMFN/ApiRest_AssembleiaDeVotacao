package desafioTecnico.api.controller;

import desafioTecnico.api.entity.associado.Associado;
import desafioTecnico.api.entity.associado.DadosAtualizacaoAssociado;
import desafioTecnico.api.entity.associado.DadosCadastroAssociado;
import desafioTecnico.api.entity.associado.ListaAssociado;
import desafioTecnico.api.repository.RepositoryAssociado;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private RepositoryAssociado repositoryAssociado;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAssociado dados){

        var cadrastro = repositoryAssociado.save(new Associado(dados));

        return ResponseEntity.ok(cadrastro);
    }

    @GetMapping
    public ResponseEntity<List<ListaAssociado>> listar (){

        var lista = repositoryAssociado.findAll().stream().map(ListaAssociado::new).toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarAssociado(@PathVariable Long id){

        var buscaAssociado = repositoryAssociado.getReferenceById(id);

        return ResponseEntity.ok(new ListaAssociado(buscaAssociado));
    }
    @PutMapping
    public ResponseEntity atualizarAssociado(@RequestBody @Valid DadosAtualizacaoAssociado dados){

        var atualizar = repositoryAssociado.getReferenceById(dados.id());
        atualizar.atualizarInformacaoAssociado(dados);

        return ResponseEntity.ok(new ListaAssociado(atualizar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarAssociado(@PathVariable Long id){

        repositoryAssociado.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
