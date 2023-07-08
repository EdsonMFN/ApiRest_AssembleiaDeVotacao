package desafioTecnico.api.controller;


import desafioTecnico.api.repository.RepositoryAssociado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private RepositoryAssociado repositoryAssociado;


}
