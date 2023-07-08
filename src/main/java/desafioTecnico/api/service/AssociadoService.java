package desafioTecnico.api.service;


import desafioTecnico.api.repository.RepositoryAssociado;
import desafioTecnico.api.repository.RepositoryVoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AssociadoService {



    @Autowired
    private RepositoryAssociado repositoryAssociado;

    @Autowired
    private RepositoryVoto repositoryVoto;


}
