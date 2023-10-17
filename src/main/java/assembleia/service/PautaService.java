package assembleia.service;

import assembleia.domains.entity.pauta.Pauta;
import assembleia.domains.model.PautaDTO;
import assembleia.domains.repository.RepositoryPauta;
import assembleia.domains.repository.RepositorySessao;
import assembleia.exception.handling.HandlerEntityNotFound;
import assembleia.rest.response.ResponsePauta;
import assembleia.rest.resquest.RequestPauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        repositoryPauta.save(pauta);

        return new ResponsePauta(PautaDTO
                .builder()
                .id(pauta.getId())
                .topico(pauta.getTopico())
                .mensagem(pauta.getMensagem())
                .build());
    }
    public ResponsePauta buscarPauta(Long idPauta){
        Pauta pauta = repositoryPauta.findById(idPauta).map(a->a)
                .orElseThrow(() -> new HandlerEntityNotFound("Entidade com id " + idPauta + " não encontrada"));

        return new ResponsePauta(PautaDTO
                .builder()
                .id(pauta.getId())
                .topico(pauta.getTopico())
                .mensagem(pauta.getMensagem())
                .build());
    }
    public List<ResponsePauta> listarPauta(){

        List<Pauta> pautas = repositoryPauta.findAll();
        List<ResponsePauta> responsePautas = new ArrayList<>();

        for (Pauta pauta : pautas){

            ResponsePauta responsePauta = new ResponsePauta(PautaDTO
                    .builder()
                    .id(pauta.getId())
                    .topico(pauta.getTopico())
                    .mensagem(pauta.getMensagem())
                    .build());

            responsePautas.add(responsePauta);
        }
        return responsePautas;
    }
    public void deletarPauta(Long idPauta){

        Pauta pauta = repositoryPauta.findById(idPauta).map(a->a)
                .orElseThrow(() -> new HandlerEntityNotFound("Entidade com id " + idPauta + " não encontrada"));
        repositoryPauta.delete(pauta);
    }
}
