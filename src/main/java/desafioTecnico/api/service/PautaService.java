package desafioTecnico.api.service;

import desafioTecnico.api.entity.pauta.Pauta;
import desafioTecnico.api.repository.RepositoryPauta;
import desafioTecnico.api.repository.RepositorySessao;
import desafioTecnico.api.controller.response.ResponsePauta;
import desafioTecnico.api.controller.resquest.RequestPauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PautaService {


    @Autowired
    private RepositorySessao repositorySessao;

    @Autowired
    private RepositoryPauta repositoryPauta;

    public ResponsePauta criarPauta(RequestPauta requestPauta){

        Pauta pauta = new Pauta();
        pauta.setMensagem(requestPauta.getMensagem());
        pauta.setTopico(requestPauta.getTopico());
        pauta = repositoryPauta.save(pauta);

        return new ResponsePauta(pauta);

    }

    public List<ResponsePauta> listagerPauta (){

        List<Pauta> pautas = repositoryPauta.findAll();

        return pautas.stream().map(ResponsePauta::new).toList();
    }

    public ResponsePauta alterarPauta(RequestPauta requestPauta){

        Pauta pauta = new Pauta();
        pauta.setTopico(requestPauta.getTopico());
        pauta.setMensagem(requestPauta.getMensagem());

        return new ResponsePauta(pauta);
    }

    public void deletarPauta (Long idPauta){

        repositoryPauta.deleteById(idPauta);
    }

}
