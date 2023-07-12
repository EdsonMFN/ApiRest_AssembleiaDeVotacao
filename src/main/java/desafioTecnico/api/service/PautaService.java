package desafioTecnico.api.service;

import desafioTecnico.api.entity.pauta.Pauta;
import desafioTecnico.api.entity.pauta.PautaDTO;
import desafioTecnico.api.repository.RepositoryPauta;
import desafioTecnico.api.repository.RepositorySessao;
import desafioTecnico.api.controller.response.ResponsePauta;
import desafioTecnico.api.controller.resquest.RequestPauta;
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

        PautaDTO pautaDTO = new PautaDTO();
        pautaDTO.setId(pauta.getId());
        pautaDTO.setTopico(pauta.getTopico());
        pautaDTO.setMensagem(pauta.getMensagem());

        ResponsePauta responsePauta = new ResponsePauta();
        responsePauta.setPautaDTO(pautaDTO);

        return responsePauta;
    }
    public ResponsePauta buscarPauta(Long idPauta){
        Optional<Pauta> pauta = repositoryPauta.findById(idPauta);

        PautaDTO pautaDTO = new PautaDTO();
        pautaDTO.setId(pauta.get().getId());
        pautaDTO.setTopico(pauta.get().getTopico());
        pautaDTO.setMensagem(pauta.get().getMensagem());

        ResponsePauta responsePauta = new ResponsePauta();
        responsePauta.setPautaDTO(pautaDTO);

        return responsePauta;
    }
    public List<ResponsePauta> listarPauta(){

        List<Pauta> pautas = repositoryPauta.findAll();
        List<ResponsePauta> responsePautas = new ArrayList<>();

        for (Pauta pauta : pautas){

            PautaDTO pautaDTO = new PautaDTO();
            pautaDTO.setId(pauta.getId());
            pautaDTO.setTopico(pauta.getTopico());
            pautaDTO.setMensagem(pauta.getMensagem());

            ResponsePauta responsePauta = new ResponsePauta();
            responsePauta.setPautaDTO(pautaDTO);

            responsePautas.add(responsePauta);
        }
        return responsePautas;
    }
    public ResponsePauta deletarPauta(Long idPauta){

        Optional<Pauta> pauta = repositoryPauta.findById(idPauta);
        repositoryPauta.delete(pauta.get());

        ResponsePauta responsePauta = new ResponsePauta();
        responsePauta.setMensagemSucesso(responsePauta.getMensagemSucesso());

        return responsePauta;
    }
}
