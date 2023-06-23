package desafioTecnico.api.service;

import desafioTecnico.api.controller.response.ResponseAssociado;
import desafioTecnico.api.controller.resquest.RequestAssociado;
import desafioTecnico.api.entity.associado.Associado;
import desafioTecnico.api.entity.voto.Voto;
import desafioTecnico.api.repository.RepositoryAssociado;
import desafioTecnico.api.repository.RepositoryVoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociadoService {



    @Autowired
    private RepositoryAssociado repositoryAssociado;

    @Autowired
    private RepositoryVoto repositoryVoto;

    public ResponseAssociado criarAssociado(Long idVoto, RequestAssociado requestAssociado, ResponseAssociado responseAssociado){

        Optional<Voto> voto = repositoryVoto.findById(idVoto);
        Associado associado = new Associado();
        associado.setNome(requestAssociado.getNome());
        associado.setCpf(requestAssociado.getCpf());
        associado.setVoto(voto.get());

        return new ResponseAssociado(associado);
    }

    public List<ResponseAssociado> listarAssociado(){

        List<Associado> associados = repositoryAssociado.findAll();

        return associados.stream().map(ResponseAssociado::new).toList();
    }

    public ResponseAssociado alterarAssociado(RequestAssociado requestAssociado){

        Associado associado = new Associado();
        associado.setNome(requestAssociado.getNome());
        associado.setCpf(requestAssociado.getCpf());

        return new ResponseAssociado(associado);
    }

    public void deletarAssociado(Long idAssociado){

       repositoryAssociado.deleteById(idAssociado);

    }
}
