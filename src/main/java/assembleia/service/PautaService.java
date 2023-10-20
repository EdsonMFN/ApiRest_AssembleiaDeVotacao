package assembleia.service;

import assembleia.domains.entity.pauta.Pauta;
import assembleia.domains.model.PautaDTO;
import assembleia.domains.repository.RepositoryPauta;
import assembleia.domains.repository.RepositorySessao;
import assembleia.exception.handling.HandlerEntityNotFound;
import assembleia.exception.handling.HandlerError;
import assembleia.rest.response.ResponsePauta;
import assembleia.rest.resquest.RequestPauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PautaService {


    @Autowired
    private RepositorySessao repositorySessao;

    @Autowired
    private RepositoryPauta repositoryPauta;

    public ResponsePauta criarPauta(RequestPauta requestPauta){

        try {
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

        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public ResponsePauta buscarPauta(Long idPauta){

        Pauta pauta = repositoryPauta.findById(idPauta).map(a->a)
                .orElseThrow(() -> new HandlerEntityNotFound("Entidade com id " + idPauta + " não encontrada"));
        try {
            return new ResponsePauta(PautaDTO
                    .builder()
                    .id(pauta.getId())
                    .topico(pauta.getTopico())
                    .mensagem(pauta.getMensagem())
                    .build());

        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }

    }
    public List<ResponsePauta> listarPauta(){

       try {
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

       }catch (Exception ex){
           throw new HandlerError(ex.getMessage());
       }
    }
    public void deletarPauta(Long idPauta){

        Pauta pauta = repositoryPauta.findById(idPauta).map(a->a)
                .orElseThrow(() -> new HandlerEntityNotFound("Entidade com id " + idPauta + " não encontrada"));
        try {
            repositoryPauta.delete(pauta);

        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
}
